package com.example.mysecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.mysecurity.mapper")
public class MySecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySecurityApplication.class, args);
    }

}
