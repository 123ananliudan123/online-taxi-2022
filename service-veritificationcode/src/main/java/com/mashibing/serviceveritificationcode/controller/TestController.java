package com.mashibing.serviceveritificationcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test222")
    public String test(){
        return "service-verificationcode";
    }
}
