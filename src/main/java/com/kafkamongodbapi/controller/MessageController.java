package com.kafkamongodbapi.controller;

import com.kafkamongodbapi.model.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("testTopic", request.message());
    }

    @GetMapping
    public void publish() {
        /* Reachable through localhost:8080/messages, so you don't need to use Postman, you lazy*/
        kafkaTemplate.send("testTopic", "The controller is working fine!");
    }
}
