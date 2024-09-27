package com.boardgo.chattingbackend.domain.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import com.boardgo.chattingbackend.domain.chat.controller.request.ChatRequest;
import com.boardgo.chattingbackend.domain.chat.service.ChatPublisher;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
	private final ChatPublisher chatPublisher;

	@MessageMapping("/chat.sendMessage")
	public void sendMessage(@Payload @Valid ChatRequest chatRequest) {
		chatPublisher.publish(chatRequest);
	}
}
