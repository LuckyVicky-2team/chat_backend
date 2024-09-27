package com.boardgo.chattingbackend.domain.chat.controller.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ChatRequest(
	@NotNull
	Long roomId,
	@NotEmpty
	String content,
	@NotNull
	Long senderId,
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
	LocalDateTime sendDatetime
) {
}
