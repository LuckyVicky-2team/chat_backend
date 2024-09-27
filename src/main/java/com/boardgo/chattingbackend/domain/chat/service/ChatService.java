package com.boardgo.chattingbackend.domain.chat.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boardgo.chattingbackend.domain.chat.entity.ChatMessage;
import com.boardgo.chattingbackend.domain.chat.repository.ChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
	private final ChatRepository chatRepository;
	private final SimpMessagingTemplate messagingTemplate;

	public void sendMessage(ChatMessage message) {
		messagingTemplate.convertAndSend("/topic/chat/" + message.getRoomId(), message);
	}

	@Transactional
	public ChatMessage saveMessage(ChatMessage message) {
		return chatRepository.save(message);
	}
}
