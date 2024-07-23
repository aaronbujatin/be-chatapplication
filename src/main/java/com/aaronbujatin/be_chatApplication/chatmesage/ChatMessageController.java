package com.aaronbujatin.be_chatApplication.chatmesage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "localhost:4200")
@Controller
@RequiredArgsConstructor
public class ChatMessageController {
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessageDto sendMessage(@DestinationVariable String roomId, ChatMessageDto chatMessageDto){
        chatMessageService.saveMessage(roomId, chatMessageDto);
        return new ChatMessageDto(chatMessageDto.message(), chatMessageDto.message(), chatMessageDto.sendTime());
    }

    @GetMapping("/api/chat/{roomId}")
    public ResponseEntity<List<ChatMessage>> getAllMessage(@PathVariable String roomId){
        return ResponseEntity.ok(chatMessageService.getRoomById(roomId));
    }
}
