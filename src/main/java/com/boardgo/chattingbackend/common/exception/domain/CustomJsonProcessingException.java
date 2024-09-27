package com.boardgo.chattingbackend.common.exception.domain;

public class CustomJsonProcessingException extends RuntimeException {
	public CustomJsonProcessingException(String message) {
		super("Redis[String -> Object] 파싱 중에 오류 발생 \n" + message);
	}
}
