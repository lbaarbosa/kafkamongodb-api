package com.kafkamongodbapi.controller;

import com.kafkamongodbapi.domain.dto.MessageRequestDTO;
import com.kafkamongodbapi.domain.dto.request.MessageRequest;
import com.kafkamongodbapi.domain.dto.response.MessageResponse;
import com.kafkamongodbapi.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(path = "/kafka")
    public void publish(@RequestBody MessageRequest request) {
        messageService.sendThenSave();
    }

    @GetMapping(path = "/kafka")
    public void publish() {
        /*
        Reachable through localhost:8080/messages
        So you don't need to use Postman, you lazy :P
        */
        messageService.sendThenSave();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody MessageResponse saveMessage(@Valid MessageRequest messageRequest) {
        MessageRequestDTO messageRequestDTO = new MessageRequestDTO(messageRequest);
        return new MessageResponse(messageService.saveMessage(messageRequestDTO));
    }

    @GetMapping(path = "/all")
    public List<MessageResponse> getAllMessages() {
        return messageService.getAllMessages().stream().map(MessageResponse::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public Optional<MessageResponse> getMessageById(@PathVariable int id) {
        return messageService.getMessageById(id).map(MessageResponse::new);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMessageById(@PathVariable int id) {
        messageService.deleteMessageById(id);
    }

}
