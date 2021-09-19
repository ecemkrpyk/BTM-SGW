package com.argelastaj.springbootweblogicbtm.rabbitMq.listener.concretes;

import com.argelastaj.springbootweblogicbtm.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class UserListener {

    @RabbitListener(queues = "${sr.rabbit.queue.name}")
    public void  handleMessage(String s){
        System.out.println("Message Received");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        User user = gson.fromJson(s,User.class);

        System.out.println("userlistener :"+user.toString());
    }

}
