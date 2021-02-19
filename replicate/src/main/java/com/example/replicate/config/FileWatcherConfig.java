package com.example.replicate.config;

import com.example.replicate.util.FileWatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FileWatcherConfig {
    @Bean(name = "fileWatcherBean")
    public FileWatcher fileWatcherBean(){
        return new FileWatcher();
    }
}
