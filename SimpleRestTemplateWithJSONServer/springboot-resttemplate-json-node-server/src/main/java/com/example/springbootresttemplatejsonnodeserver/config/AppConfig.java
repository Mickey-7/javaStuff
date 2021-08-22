package com.example.springbootresttemplatejsonnodeserver.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        var factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }

//    Alternatively, we can use the RestTemplateBuilder to do the job.
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder
//                .setConnectTimeout(Duration.ofMillis(3000))
//                .setReadTimeout(Duration.ofMillis(3000))
//                .build();
//    }
}
