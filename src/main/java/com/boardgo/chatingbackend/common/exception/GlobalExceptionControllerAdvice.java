package com.boardgo.chatingbackend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.boardgo.chatingbackend.common.exception.domain.CustomJsonProcessingException;
import com.boardgo.chatingbackend.common.exception.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionControllerAdvice {
	/**
	 * Redis Json parsing Error
	 */
	@ExceptionHandler(CustomJsonProcessingException.class)
	public ResponseEntity<ErrorResponse> JsonParseExHandler(CustomJsonProcessingException e) {
		return ResponseEntity.badRequest()
			.body(
				ErrorResponse.builder()
					.errorCode(HttpStatus.BAD_REQUEST.value())
					.messages(e.getMessage())
					.build());
	}

}
