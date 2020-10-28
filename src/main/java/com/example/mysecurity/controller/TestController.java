package com.example.mysecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @PostMapping("/hello")
    public String hello() {
        return "hello";
    }


}
