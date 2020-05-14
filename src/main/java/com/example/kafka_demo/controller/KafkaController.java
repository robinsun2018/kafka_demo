package com.example.kafka_demo.controller;

import com.example.kafka_demo.kafka.KafkaProducer;
import com.example.kafka_demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/createMsg")
    public void createMsg() {
        User user = new User();
        user.setId(new Random().nextInt());
        user.setAge(new Random().nextInt());
        user.setName("suncs"+new Random().nextInt());
        kafkaProducer.sendUserMessage(user);
    }

}