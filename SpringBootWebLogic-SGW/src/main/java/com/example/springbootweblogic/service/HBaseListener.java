package com.example.springbootweblogic.service;

import com.example.springbootweblogic.converters.MyConverter;
import com.example.springbootweblogic.hbase.config.HBase;
import com.example.springbootweblogic.model.Incoming_MessageHB;
import com.example.springbootweblogic.model.Incoming_MessageORC;
import com.example.springbootweblogic.model.User;
import com.example.springbootweblogic.model.UserORC;
import com.example.springbootweblogic.rabbit.producerConcrete.UserProducer;
import com.example.springbootweblogic.repository.concretes.HBaseMessageRepository;
import com.example.springbootweblogic.repository.concretes.HBaseUserRepository;
import com.example.springbootweblogic.repository.concretes.MessageService;
import com.example.springbootweblogic.repository.concretes.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HBaseListener {

    Logger logger = LoggerFactory.getLogger(HBaseListener.class);
    @Autowired
    private UserService userService;
    
    @Autowired
    private MessageService messageService;
    @Autowired
    private HBaseUserRepository repository;
    @Autowired
    private HBaseMessageRepository hbaseMessageRepository;
    @Autowired
    HBase hBase;
    @Autowired
    UserProducer userProducer;
    @Autowired
    MyConverter converter;

    @Scheduled(fixedRate = 500)
    public void ListenHbase() {

        List<User> usrList = new ArrayList<>();

        try {
            usrList = repository.getAll(hBase.createConnection(), "user");
        } catch (IOException e) {
            logger.error(e.getMessage());
            ;
        }
        for (User user : usrList) {
            UserORC user2 = converter.convert(user);
            userService.addUser(user2);
            userProducer.sendToQueue(user);
            try {
                repository.deleteRows(hBase.createConnection(), "user", user.getUuid());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            logger.info(user.toString());

        }
    }
    
    
    @Scheduled(fixedRate = 500)
    public void ListenMessageHbase() {

        List<Incoming_MessageHB> messageList = new ArrayList<>();

        try {
        	messageList = hbaseMessageRepository.getAll(hBase.createConnection(), "message");
        } catch (IOException e) {
            logger.error(e.getMessage());
            
        }
        for (Incoming_MessageHB messageHB : messageList) {
            Incoming_MessageORC message = converter.convert(messageHB);
            messageService.addMessage(message);
            System.out.println(messageHB.getLastUpdateTime());
            System.out.println(message.getLastUpdateTime());
            
            try {
                repository.deleteRows(hBase.createConnection(), "message", messageHB.getUuid());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            logger.info(messageHB.toString());

        }
    }
    
    
   
    
}
