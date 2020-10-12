package com.example.mysecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mysecurity.dao")
public class MySecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySecurityApplication.class, args);
    }

}
