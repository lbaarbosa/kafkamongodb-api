package com.kafkamongodbapi.controller;

import com.kafkamongodbapi.kafka.model.MessageRequest;
import com.kafkamongodbapi.mongodb.Message;
import com.kafkamongodbapi.mongodb.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate, MessageRepository messageRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageRepository = messageRepository;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        sendThenSave();
    }

    @GetMapping
    public void publish() {
        /*
        Reachable through localhost:8080/messages
        So you don't need to use Postman, you lazy :P
        */
        sendThenSave();
    }

    private void sendThenSave() {
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
