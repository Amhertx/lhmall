package com.lhy.lhmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lhy.lhmall.dao")
@SpringBootApplication
public class LhmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(LhmallApplication.class, args);
    }

}
