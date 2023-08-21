package com.kafkamongodbapi.service;

import com.kafkamongodbapi.domain.dto.MessageRequestDTO;
import com.kafkamongodbapi.domain.dto.MessageResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    void sendThenSave();
    public MessageResponseDTO saveMessage(MessageRequestDTO dto);
    public List<MessageResponseDTO> getAllMessages();
    public Optional<MessageResponseDTO> getMessageById(int id);
    public void deleteMessageById(int id);
}
