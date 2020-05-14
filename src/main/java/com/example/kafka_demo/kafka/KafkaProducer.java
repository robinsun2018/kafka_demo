package com.example.kafka_demo.kafka;

import com.example.kafka_demo.pojo.User;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Kafka消息生产类
 */
@Slf4j
@Component
public class KafkaProducer {


    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.user}")
    private String topicUser;//topic名称

    /**
     * 发送用户消息
     *
     * @param user 用户信息
     */
    public void sendUserMessage(User user) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = builder.create().toJson(user);
        kafkaTemplate.send(topicUser, message);
        log.info("\n生产消息至Kafka\n" + message);
    }
}
