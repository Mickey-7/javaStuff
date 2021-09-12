package com.example.resttemplateerrorhandlingclient.cron;

import com.example.resttemplateerrorhandlingclient.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateCron {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateCron.class);
    @Autowired
    private RestTemplateService restTemplateService;

    @Scheduled(cron = "* 52 10 * * *")
    private void restTemplateCron(){

        // handle exception if server is down
        // using try catch

        try{
            restTemplateService.restTemplatePost();
        }catch (Exception e){
            LOGGER.info("{}",e);
            for(int i=0; i<=3; i++){
                try{
                    restTemplateService.restTemplatePost();
                }catch (Exception e1){
                    LOGGER.info("Exception retry #{}",i);
                }
            }
        }
    }
}
