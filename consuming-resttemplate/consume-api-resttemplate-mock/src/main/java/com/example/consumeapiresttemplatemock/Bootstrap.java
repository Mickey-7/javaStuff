package com.example.consumeapiresttemplatemock;

import com.example.consumeapiresttemplatemock.controller.MockController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

    @Autowired
    private MockController mockController;

    @EventListener(ContextRefreshedEvent.class)
    public void onInit(){
        mockController.exchange();
    }

}
