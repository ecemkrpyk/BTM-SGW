package com.argelastaj.springbootweblogicbtm.controller;

import com.argelastaj.springbootweblogicbtm.checker.IsAlive;
import com.argelastaj.springbootweblogicbtm.hbase.HBaseConfig;
import com.argelastaj.springbootweblogicbtm.hbase.HBaseHelper;
import com.argelastaj.springbootweblogicbtm.kafka.service.Producer;
import com.argelastaj.springbootweblogicbtm.model.Incoming_Message;
import com.argelastaj.springbootweblogicbtm.model.User;
import org.apache.hadoop.hbase.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {
    Logger logger = LoggerFactory.getLogger(ApiController.class);

    private final Producer producer;

    @Autowired
    public ApiController(Producer producer){
        this.producer=producer;
    }
    @Autowired
    HBaseConfig config;
    @Autowired
    IsAlive isAlive;

    @PostConstruct
    private void createUserTable() {

        HBaseHelper helper = new HBaseHelper(config);
        try{
            Connection connection= config.createConnection();
            helper.createTable(connection,"user",new String[]{"personal_info"});
        }catch(IOException e){
            System.out.println(e.getMessage()+ "when create new table");

        }}

    @PostConstruct
    private void createMessageTable() {

        HBaseHelper helper = new HBaseHelper(config);
        try{
            Connection connection= config.createConnection();
            //CONNECTİON, TABLO ADI VE COLUMN FAMILY ALANI
            helper.createTable(connection,"message",new String[]{"message_info"});
        }catch(IOException e){
            System.out.println(e.getMessage()+ "when create new table");

        }}


    @PostMapping("/saveIncommingMessage")
    public ResponseEntity<String> saveMessage(
    		@Valid @RequestBody Incoming_Message incoming_message,

    		@RequestParam("ContentPartnerId") Integer ContentPartnerId,
    		@RequestParam("TopicName") String TopicName

    		)throws IOException{

    	incoming_message.setMessageId((int) (System.currentTimeMillis() & 0xfffffff));
    	incoming_message.setLifecycleStatusId((int) (System.currentTimeMillis() & 0xfffffff));
    	incoming_message.setMessageContentId((int) (System.currentTimeMillis() & 0xfffffff));
    	incoming_message.setBulkTransactionId((int) (System.currentTimeMillis() & 0xfffffff));
    	incoming_message.setSessionGroupId((int) (System.currentTimeMillis() & 0xfffffff));

    	
        this.producer.sendMessage(incoming_message,ContentPartnerId,TopicName);
        return new ResponseEntity<String>(incoming_message.toString(), HttpStatus.OK);

    }


    @PostMapping("/saveUser")
    public ResponseEntity<String> save(@Valid @RequestBody User user)throws IOException{

        user.setUuid(UUID.randomUUID().toString());
        this.producer.sendUser(user,"test_topic");
        return new ResponseEntity<String>(user.toString(), HttpStatus.OK);

    }

    @PostMapping(value = "/users",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = "application/json")
    public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception{

        for(MultipartFile file:files){
            List<User> users =parseCSVFile(file);
            logger.info("saving list of users of size {}",users.size(),""+Thread.currentThread().getName());
            for(User user:users) {
                this.producer.sendUser(user, "test_topic");
            }

        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private List<User> parseCSVFile(final MultipartFile file) throws Exception {

        final List<User> users = new ArrayList<>();

        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                String line;

                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setUuid(data[0]);
                    user.setName(data[1]);
                    user.setSurname(data[2]);
                    user.setGender(data[3]);
                    user.setAge(Integer.valueOf(data[4]));
                    users.add(user);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }


    }
}
