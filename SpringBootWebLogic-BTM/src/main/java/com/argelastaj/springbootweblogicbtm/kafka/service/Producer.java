package com.argelastaj.springbootweblogicbtm.kafka.service;


import com.argelastaj.springbootweblogicbtm.model.Incoming_Message;
import com.argelastaj.springbootweblogicbtm.model.User;
import com.argelastaj.springbootweblogicbtm.utilities.ContentPartnerCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer extends ContentPartnerCounter {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    


    public void sendUser(User user, String topic){
        System.out.println("Producer runs");
        this.kafkaTemplate.send(topic,user);
    }
    
    public void sendMessage(Incoming_Message incoming_message,Integer ContentPartnerId, String topic){
        System.out.println("Producer runs");
        if(!topic.contains("ssgw")) {
            this.kafkaTemplate.send(topic,0,topic.toString()+"-0",incoming_message);
        }
        else
        {
            incrementRequestCount(ContentPartnerId,1);
            if(getPreviousTimeCount(ContentPartnerId) <= 5) {

            	System.out.println("0. partition");
            	this.kafkaTemplate.send(topic,0,"ssgw-0",incoming_message);

            }
            else if(getPreviousTimeCount(ContentPartnerId) > 5 && getPreviousTimeCount(ContentPartnerId) <= 10){
            	System.out.println("1. partition");
            	this.kafkaTemplate.send(topic,1,"ssgw-1",incoming_message);
            	
            }
            else if (getPreviousTimeCount(ContentPartnerId) > 10) {
            	System.out.println("2. partition");
            	this.kafkaTemplate.send(topic,2,"ssgw-2",incoming_message);

            }
        }
    }
}
