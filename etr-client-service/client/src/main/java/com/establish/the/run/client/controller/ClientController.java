package com.establish.the.run.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
public class ClientController {

    private final WebClient client;

    @GetMapping("/test")
    public Mono<String> testData(){
        return client.get().uri("http://ETR-NFL/admin/test").retrieve().bodyToMono(String.class);
    }

}
