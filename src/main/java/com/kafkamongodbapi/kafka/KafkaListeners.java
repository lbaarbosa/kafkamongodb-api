package com.kafkamongodbapi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "testTopic", groupId = "groupId")
    public void listener(String data) {
        LOGGER.info("Message received -> {}", data);
    }
}
