package com.example.replicate.util;

import com.example.replicate.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatcher implements Runnable{

    @Value("${directoryOnly}")
    private String directoryOnly;

    @Autowired
    private XMLValidator xmlValidator;

    @Resource(name = "XMLToPOJOBean")
    private XMLToPOJO xmlToPOJO;

    public static Path filename = null;

    @Override
    public void run() {
        try {
            //create a instance of watch service
            WatchService watchService = FileSystems.getDefault().newWatchService();

            //register the directory below with a watch service
            Path logDir = Paths.get(directoryOnly);
            logDir.register(watchService,ENTRY_CREATE,ENTRY_DELETE,ENTRY_MODIFY);

            //monitor the logDir at listen for change notification
            while(true){
                WatchKey watchKey = watchService.take();
                for (WatchEvent<?> event: watchKey.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                     filename = (Path) event.context();

                    if(ENTRY_CREATE.equals(kind)){
                        System.out.println(filename+" was created");

                        boolean isValid = false;
                        try {
                            if(isValid = xmlValidator.validator()){
                                try {
                                    Employee employee = xmlToPOJO.xmlToPOJO();
                                    System.out.println(employee.getEmployeeId());
                                    System.out.println(employee.getName());
                                    System.out.println(employee.getSalary());
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (SAXException e) {
                            e.printStackTrace();
                        }


                    }

                    if(ENTRY_DELETE.equals(kind)){
                        System.out.println(filename+" was deleted");
                    }

                    if(ENTRY_MODIFY.equals(kind)){
                        System.out.println(filename+" was modified");
                    }
                }
                watchKey.reset();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
