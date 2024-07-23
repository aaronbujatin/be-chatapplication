package com.aaronbujatin.be_chatApplication.chatmesage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public void saveMessage(String roomId, ChatMessageDto chatMessageDto){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage(chatMessageDto.message());
        chatMessage.setUsername(chatMessageDto.username());
        chatMessage.setSendTime(chatMessageDto.sendTime());
        chatMessage.setRoomId(roomId);
        chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getRoomById(String roomId){
        return chatMessageRepository.findByRoomId(roomId);
    }

}
