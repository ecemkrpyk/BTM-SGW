package com.example.springbootweblogic.rabbit.producerConcrete;

import com.example.springbootweblogic.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    @Value("${sr.rabbit.routing.name}")
    private String routingName;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    Logger logger = LoggerFactory.getLogger(UserProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendToQueue(User user) {
        logger.info("Notification sended id: " + user.getUuid());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonstr = gson.toJson(user);
        rabbitTemplate.convertAndSend(exchangeName, routingName, jsonstr);


    }

}
