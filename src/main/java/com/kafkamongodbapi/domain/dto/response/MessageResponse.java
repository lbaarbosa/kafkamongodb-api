package com.kafkamongodbapi.domain.dto.response;

import com.kafkamongodbapi.domain.dto.MessageResponseDTO;
import lombok.Data;

@Data
public class MessageResponse {

    private String id;
    private String content;

    public MessageResponse() {
        super();
    }

    public MessageResponse(String content) {
        this.content = content;
    }

    public MessageResponse(MessageResponseDTO dto) {
        this.id = dto.getId();
        this.content = dto.getContent();
    }

}
