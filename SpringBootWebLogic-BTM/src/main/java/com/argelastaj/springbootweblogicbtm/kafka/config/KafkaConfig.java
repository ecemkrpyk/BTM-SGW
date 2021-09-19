package com.argelastaj.springbootweblogicbtm.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {
    @Value("${sr.kafka.topic.test}")
    private String TEST_TOPIC;

    @Bean
    public NewTopic test_topic(){
    	return new NewTopic(TEST_TOPIC,3, (short) 1);
    }

    @Value("${sr.kafka.topic.vip}")
    private String VIP_TOPIC;

    @Bean
    public NewTopic VIP(){
    	return new NewTopic(VIP_TOPIC,1, (short) 1);
    }

    @Value("${sr.kafka.topic.ssgw}")
    private String SSGW_TOPIC;

    @Bean
    public NewTopic SSGW(){
    	return new NewTopic(SSGW_TOPIC, 3, (short) 1); //3 partition olucak
    }

    @Value("${sr.kafka.topic.corp}")
    private String CORPUI_TOPIC;

    @Bean
    public NewTopic CORP_UI(){
    	return new NewTopic(CORPUI_TOPIC,1, (short) 1);
    }
}
