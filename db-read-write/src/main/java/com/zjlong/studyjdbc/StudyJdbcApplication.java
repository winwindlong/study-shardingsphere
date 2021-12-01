package com.zjlong.studyjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjlong.studyjdbc.business.mapper")
public class StudyJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyJdbcApplication.class, args);
    }

}
