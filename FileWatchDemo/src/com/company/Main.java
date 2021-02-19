package com.company;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            // Creates a instance of WatchService.
            WatchService watchService = FileSystems.getDefault().newWatchService();

            // Registers the logDir below with a watch service.
            Path logDir = Paths.get("C:\\Users\\donat\\Documents\\lunacy");
            logDir.register(
                    watchService,
                    ENTRY_CREATE,
                    ENTRY_MODIFY,
                    ENTRY_DELETE
            );

            // Monitor the logDir at listen for change notification.
            while (true){
                WatchKey key = watchService.take();
                for (WatchEvent<?> event: key.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    Path filename = (Path) event.context();

                    if (ENTRY_CREATE.equals(kind)){
                        System.out.println("Entry was created on log dir");
                        System.out.printf("A new file %s was created.%n",filename.getFileName());
                    }else if(ENTRY_MODIFY.equals(kind)){
                        System.out.println("Entry was modified on log dir");
                        System.out.printf("A new file %s was modified.%n",filename.getFileName());
                    }else if(ENTRY_DELETE.equals(kind)){
                        System.out.println("Entry was deleted on log dir");
                        System.out.printf("A new file %s was deleted.%n",filename.getFileName());
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
