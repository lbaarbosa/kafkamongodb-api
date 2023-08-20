package com.kafkamongodbapi.controller;

import com.kafkamongodbapi.kafka.model.MessageRequest;
import com.kafkamongodbapi.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        messageService.sendThenSave();
    }

    @GetMapping
    public void publish() {
        /*
        Reachable through localhost:8080/messages
        So you don't need to use Postman, you lazy :P
        */
        messageService.sendThenSave();
    }

}
