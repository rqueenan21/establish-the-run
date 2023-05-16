package com.establish.the.run.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtrController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello";
    }

}
