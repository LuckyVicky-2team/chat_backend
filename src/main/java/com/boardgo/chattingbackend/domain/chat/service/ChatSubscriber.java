package com.boardgo.chattingbackend.domain.chat.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import com.boardgo.chattingbackend.common.exception.domain.CustomJsonProcessingException;
import com.boardgo.chattingbackend.domain.chat.entity.ChatMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatSubscriber implements MessageListener {
	private final ChatService chatService;
	private final ObjectMapper objectMapper;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		try {
			String messageBody = new String(message.getBody());
			ChatMessage chatMessage = objectMapper.readValue(messageBody, ChatMessage.class);
			log.info("chatMessage.roomId: {}", chatMessage.getRoomId());
			log.info("chatMessage.content: {}", chatMessage.getContent());
			log.info("chatMessage.sendDatetime: {}", chatMessage.getSendDatetime());
			chatService.sendMessage(chatMessage);
		} catch (JsonProcessingException e) {
			throw new CustomJsonProcessingException(e.getMessage());
		}
	}
}
