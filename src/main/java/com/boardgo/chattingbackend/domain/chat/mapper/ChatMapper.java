package com.boardgo.chattingbackend.domain.chat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.boardgo.chattingbackend.domain.chat.controller.request.ChatRequest;
import com.boardgo.chattingbackend.domain.chat.entity.ChatMessage;

@Mapper
public interface ChatMapper {
	ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

	@Mapping(source = "senderId", target = "userId")
	ChatMessage toChatMessage(ChatRequest chatRequest);
}
