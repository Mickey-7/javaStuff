package com.example.resttemplateerrorhandlingclient.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "com.example.resttemplateerrorhandlingclient.cron")
@EnableScheduling
public class CronConfig {
}
