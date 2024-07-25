package com.aaronbujatin.be_chatApplication.chatmesage;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;


public record ChatMessageDto(String message, String userId, LocalDateTime sendTime) {
}
