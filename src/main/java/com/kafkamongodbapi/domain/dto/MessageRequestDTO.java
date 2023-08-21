package com.kafkamongodbapi.domain.dto;

import com.kafkamongodbapi.domain.dto.request.MessageRequest;
import lombok.Data;

@Data
public class MessageRequestDTO {

    private String id;
    private String content;

    public MessageRequestDTO() {
        super();
    }

    public MessageRequestDTO(String content) {
        this.content = content;
    }

    public MessageRequestDTO(MessageRequest messageRequest) {
        this.content = messageRequest.message();
    }
}
