package com.kafkamongodbapi.service.impl;

import com.kafkamongodbapi.mongodb.entity.Message;
import com.kafkamongodbapi.mongodb.repository.MessageRepository;
import com.kafkamongodbapi.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate, MessageRepository messageRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageRepository = messageRepository;
    }

    @Override
    public void sendThenSave() {
        Message message = new Message("The controller is working fine!");
        try {
            kafkaTemplate.send("testTopic", message.getContent());
            LOGGER.info("Message sent to Kafka!");
            messageRepository.save(message);
            LOGGER.info("Message saved to MongoDB!");
            LOGGER.info("Operation finished at: {}", LocalTime.now());
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
            e.printStackTrace();
        }
    }
}
