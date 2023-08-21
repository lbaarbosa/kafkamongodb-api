package com.kafkamongodbapi.mongodb.entity;

import com.kafkamongodbapi.domain.dto.MessageRequestDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Message {
    @Id
    private String id;
    private String content;

    public Message() {
        super();
    }

    public Message(String content) {
        this.content = content;
    }

    public Message(MessageRequestDTO dto) {
        this.id = dto.getId();
        this.content = dto.getContent();
    }
}
