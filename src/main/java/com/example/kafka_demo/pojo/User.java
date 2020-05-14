package com.example.kafka_demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "user")
public class User {

    private int id;
    private String name;
    private int age;


}
