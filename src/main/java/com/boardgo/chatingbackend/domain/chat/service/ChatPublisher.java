package com.boardgo.chatingbackend.domain.chat.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boardgo.chatingbackend.domain.chat.controller.request.ChatRequest;
import com.boardgo.chatingbackend.domain.chat.entity.ChatMessage;
import com.boardgo.chatingbackend.domain.chat.mapper.ChatMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatPublisher {
	private final RedisTemplate<String, Object> redisTemplate;
	private final ChatService chatService;
	private final ChatMapper chatMapper;

	@Transactional
	public void publish(ChatRequest chatRequest) {
		log.info("publish[ChatRequest.sendDatetime] : {}", chatRequest);
		ChatMessage chatMessage = chatMapper.toChatMessage(chatRequest);
		ChatMessage message = chatService.saveMessage(chatMessage);
		log.info("publish[ChatMessage.sendDatetime] : {}", chatMessage.getSendDatetime());
		log.info("publish[SaveMessage.sendDatetime] : {}", message.getSendDatetime());
		redisTemplate.convertAndSend("chat:" + chatRequest.roomId(), message);
	}
}
