package com.argelastaj.springbootweblogicbtm.checker;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IsAlive implements Condition {

     public static boolean SgwStatus;

    private RestTemplate restTemplate=new RestTemplate();

    private String url="http://192.168.1.38:17981/SGW/resources/sgw/isHostAvailable";
    @Scheduled(fixedRate = 3000L)
    public void sgwAlive() {
        try {
            String response = restTemplate.getForObject(url, String.class);
            if(response.contains("true"))
                 SgwStatus=true;
            else
                 SgwStatus=false;
        }catch(Exception e)
        {
            SgwStatus=false;
        }

    }


    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        return SgwStatus;
    }
}
