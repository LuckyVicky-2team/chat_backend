package com.boardgo.chatingbackend.common.exception.dto;

import lombok.Builder;

@Builder
public record ErrorResponse(int errorCode, String messages) {
}
