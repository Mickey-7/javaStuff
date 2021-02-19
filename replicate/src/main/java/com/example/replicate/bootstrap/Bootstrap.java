package com.example.replicate.bootstrap;

import com.example.replicate.util.FileWatcher;
import com.example.replicate.util.GenerateXML;
import com.example.replicate.util.XMLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class Bootstrap {

    @Resource(name = "fileWatcherBean")
    private FileWatcher fileWatcher;

    @Resource(name = "generateXML")
    private GenerateXML generateXML;


    @Resource(name = "XSDFileValidatorBean")
    private XMLValidator xmlValidator;

    @EventListener(ContextRefreshedEvent.class)
    public void onInit(){

//        try {
//            generateXML.generateXML();
//        } catch (JAXBException | IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            boolean result = xmlValidator.validator();
//            System.out.println(result);
//        } catch (SAXException | IOException e) {
//            e.printStackTrace();
//        }

        Thread fileWatcherThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    fileWatcher.run();
                }
            }
        });
        fileWatcherThread.start();



    }
}
