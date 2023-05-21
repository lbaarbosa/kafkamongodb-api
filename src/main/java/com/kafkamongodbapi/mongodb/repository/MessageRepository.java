package com.kafkamongodbapi.mongodb.repository;

import com.kafkamongodbapi.mongodb.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
