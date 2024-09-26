package com.boardgo.chatingbackend.domain.chat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boardgo.chatingbackend.domain.chat.entity.ChatMessage;

public interface ChatRepository extends MongoRepository<ChatMessage, String> {

	Optional<ChatMessage> findByRoomIdAndContent(Long roomId, String content);
}
