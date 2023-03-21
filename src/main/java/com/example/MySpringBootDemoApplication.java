package com.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.**.mapper")
public class MySpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootDemoApplication.class, args);
    }

}
