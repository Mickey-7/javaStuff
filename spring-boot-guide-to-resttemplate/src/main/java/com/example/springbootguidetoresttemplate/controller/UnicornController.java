package com.example.springbootguidetoresttemplate.controller;

import com.example.springbootguidetoresttemplate.dto.UnicornDto;
import com.example.springbootguidetoresttemplate.util.UnicornResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class UnicornController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/unicornsByEntity",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnicornResponse> createUnicornByEntity(@RequestBody UnicornDto unicornDto) {
        return restTemplate.postForEntity(
                "https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns",
                unicornDto,
                UnicornResponse.class
        );
    }


    @PostMapping(value = "/unicornsByObject",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UnicornResponse createUnicornByObject(@RequestBody UnicornDto unicornDto) throws RestClientException, JsonProcessingException {
        return restTemplate.postForObject(
                "https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns",
                unicornDto,
                UnicornResponse.class);
    }

    @GetMapping("/unicornsByEntity/{id}")
    public ResponseEntity<String> getUnicornByIdByEntity(@PathVariable final String id) {
        return restTemplate.getForEntity(
                "https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns/" + id,
                String.class);
    }


    @GetMapping("/unicornsByObject")
    public List<UnicornResponse> getUnicornByObject() {
        List<UnicornResponse> unicornResponseList = new ArrayList<>();
        unicornResponseList = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(
                "https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns",
                UnicornResponse[].class
        )));

        return unicornResponseList;
    }

    @DeleteMapping("/unicorns/{id}")
    public void deleteUnicornsByIdByEntity(@PathVariable final String id){
        restTemplate.delete("https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns/"+id);
    }


    @PutMapping(value = "/unicorns/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUnicorn(@PathVariable final String id, @RequestBody UnicornDto unicornDto){
        restTemplate.exchange(
                "https://crudcrud.com/api/75711794909c429595000490fbe7303a/unicorns"+id,
                HttpMethod.PUT,
                new HttpEntity<>(unicornDto),
                Void.class
        );
    }
}
