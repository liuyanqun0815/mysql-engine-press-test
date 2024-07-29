package com.example.mysqlabletest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mysqlabletest.dao")
public class MysqlAbleTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlAbleTestApplication.class, args);
    }

}
