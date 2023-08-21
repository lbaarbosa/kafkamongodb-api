package com.kafkamongodbapi.domain.dto;

import com.kafkamongodbapi.mongodb.entity.Message;
import lombok.Data;

@Data
public class MessageResponseDTO {

    private String id;
    private String content;

    public MessageResponseDTO() {
        super();
    }

    public MessageResponseDTO(String content) {
        this.content = content;
    }

    public MessageResponseDTO(Message message) {
        this.content = message.getContent();
    }
}
