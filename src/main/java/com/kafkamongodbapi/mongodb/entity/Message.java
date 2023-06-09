package com.kafkamongodbapi.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Message {
    @Id
    private String id;
    private String content;

    public Message(String content) {
        this.content = content;
    }
}
