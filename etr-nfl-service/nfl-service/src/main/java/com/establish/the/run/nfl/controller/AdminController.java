package com.establish.the.run.nfl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("/test")
    public Mono<String> test(){
        return Mono.just("Test");
    }

}
