package com.boardgo.chattingbackend.domain.chat.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Document("chat_message")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {
	@Id
	private String id;
	private Long roomId;
	private String userId;
	private String content;
	private LocalDateTime sendDatetime;

	@Builder
	public ChatMessage(String id, Long roomId, String userId, String content, LocalDateTime sendDatetime) {
		this.id = id;
		this.roomId = roomId;
		this.userId = userId;
		this.content = content;
		this.sendDatetime = sendDatetime;
	}
}
