package com.aaronbujatin.be_chatApplication.chatmesage;

import lombok.Data;

import java.time.LocalTime;


public record ChatMessageDto(String message, String username, LocalTime sendTime) {
}
