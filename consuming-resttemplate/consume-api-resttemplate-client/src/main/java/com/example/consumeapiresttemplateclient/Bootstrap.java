package com.example.consumeapiresttemplateclient;

import com.example.consumeapiresttemplateclient.controller.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

    @Autowired
    private ClientController clientController;

    @EventListener(ContextRefreshedEvent.class)
    public void onInit(){
//        clientController.getForObject();
//        clientController.exchange();
//        clientController.headForHeaders();
//        clientController.getForEntity();
//        clientController.delete();
//        clientController.put();
//        clientController.postForObject();
        clientController.postForLocation();
    }
}
