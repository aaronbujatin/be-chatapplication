package com.aaronbujatin.be_chatApplication.chatmesage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public void saveMessage(String roomId, ChatMessageDto chatMessageDto){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage(chatMessageDto.message());
        chatMessage.setUserId(chatMessageDto.userId());
        chatMessage.setSendTime(LocalDateTime.now());
        chatMessage.setRoomId(roomId);
        chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getRoomById(String roomId){
        List<ChatMessage> chatMessages = chatMessageRepository.findByRoomId(roomId);
        log.info("Returning list of Chatmessages : " + chatMessages.toString());
        return chatMessages;

    }

}
