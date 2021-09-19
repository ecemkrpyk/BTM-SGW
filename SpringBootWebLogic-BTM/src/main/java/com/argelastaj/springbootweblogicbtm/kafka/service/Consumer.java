package com.argelastaj.springbootweblogicbtm.kafka.service;


import com.argelastaj.springbootweblogicbtm.checker.IsAlive;
import com.argelastaj.springbootweblogicbtm.hbase.HBaseConfig;
import com.argelastaj.springbootweblogicbtm.hbase.HBaseHelper;
import com.argelastaj.springbootweblogicbtm.model.Incoming_Message;
import com.argelastaj.springbootweblogicbtm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class Consumer  {




	@Autowired
    HBaseConfig config;
	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
    HBaseHelper myBase = new HBaseHelper(config);


    @Scheduled(fixedRate = 3000L)
	public void SgwConsumer()
	{
		MessageListenerContainer listenerContainer1 = kafkaListenerEndpointRegistry.getListenerContainer("ssgwid");
		MessageListenerContainer listenerContainer2 = kafkaListenerEndpointRegistry.getListenerContainer("ssgwid2");
		MessageListenerContainer listenerContainer3 = kafkaListenerEndpointRegistry.getListenerContainer("ssgwid3");
		MessageListenerContainer listenerContainer4 = kafkaListenerEndpointRegistry.getListenerContainer("ssgwid4");
		if(IsAlive.SgwStatus)
		{

        listenerContainer1.start();
        listenerContainer2.start();
		listenerContainer3.start();
		listenerContainer4.start();

		}else
		{
			listenerContainer1.stop();
			listenerContainer2.stop();
			listenerContainer3.stop();
			listenerContainer4.stop();
		}
	}
    @KafkaListener(topics="test_topic", groupId="group_id")
    public void consumeUser(User user) throws IOException {

        myBase.putRows(config.createConnection(),"user", new String[]{user.getUuid()+":personal_info:name:"+user.getName(),
				user.getUuid()+":personal_info:surname:"+user.getSurname(),
				user.getUuid()+":personal_info:age:"+user.getAge(),
				user.getUuid()+":personal_info:gender:"+user.getGender()});


    }

    public String[] convertMessageToHbase(Incoming_Message message) {

    	String uuid= UUID.randomUUID().toString();

    	return new String[] {
    			uuid + ":message_info:messageId:" +message.getMessageId(),
    			uuid + ":message_info:lifecycleStatusId:" +message.getLifecycleStatusId(),
    			uuid + ":message_info:messageContentId:" +message.getMessageContentId(),
    			uuid + ":message_info:bulkTransactionId:" +message.getBulkTransactionId(),
    			uuid + ":message_info:recipientAddress:" +message.getRecipientAddress(),
    			uuid + ":message_info:lastUpdateTime:" +message.getLastUpdateTime().getTime(),
    			uuid + ":message_info:retryCount:" +message.getRetryCount(),
    			uuid + ":message_info:sessionGroupId:" +message.getSessionGroupId(),
    			uuid + ":message_info:messageSegmentCount:" +message.getMessageSegmentCount(),
    			uuid + ":message_info:totalSegmentCount:" +message.getTotalSegmentCount(),
    			uuid + ":message_info:cdrCount:" +message.getCdrCount(),
    			uuid + ":message_info:restartTime:" +message.getRestartTime(),
    			uuid + ":message_info:stopTime:" +message.getStopTime(),
    			uuid + ":message_info:hostId:" +message.getHostId(),
    			uuid + ":message_info:endDateTime:" +message.getEndDateTime(),
    			uuid + ":message_info:cqIdListString:" +message.getCqIdListString(),
    			uuid + ":message_info:partitionPart:" +message.getPartitionPart(),
    			uuid + ":message_info:isInternational:" +message.getIsInternational()

    	};
    }

    @KafkaListener(topics="vip")
    public void vipConsumeMessage(Incoming_Message message) throws IOException {

    	System.out.println("vip");
    	//System.out.println(message.toString());

        myBase.putRows(config.createConnection(),"message",convertMessageToHbase(message));
    }


     @KafkaListener(id="ssgwid",topics="ssgw",groupId="group_id", autoStartup = "false")
    public void ssgwConsumeMessage(Incoming_Message message) throws IOException {
    	System.out.println("ssgw1: "+message.getMessageId());

    	 myBase.putRows(config.createConnection(),"message",convertMessageToHbase(message));


    }
	@KafkaListener(id="ssgwid2",topics="ssgw",groupId="group_id",autoStartup = "false")
	public void ssgwConsumeMessage2(Incoming_Message message) throws IOException {
		System.out.println("ssgw2: "+message.getMessageId());

		myBase.putRows(config.createConnection(),"message",convertMessageToHbase(message));


	}
	@KafkaListener(id="ssgwid3",topics="ssgw",groupId="group_id",autoStartup = "false")
	public void ssgwConsumeMessage3(Incoming_Message message) throws IOException {
		System.out.println("ssgw3: "+message.getMessageId());

		myBase.putRows(config.createConnection(),"message",convertMessageToHbase(message));


	}
	@KafkaListener(id="ssgwid4",topics="ssgw",groupId="group_id",autoStartup = "false")
	public void ssgwConsumeMessage4(Incoming_Message message) throws IOException {
		System.out.println("ssgw4: "+message.getMessageId());

		myBase.putRows(config.createConnection(),"message",convertMessageToHbase(message));


	}


    @KafkaListener(topics="corp_ui", groupId="group_id")
    public void corpUIConsumeMessage(Incoming_Message message) throws IOException {

    	System.out.println("corp_ui");
    	 myBase.putRows(config.createConnection(),"message",convertMessageToHbase(message));
    }





}