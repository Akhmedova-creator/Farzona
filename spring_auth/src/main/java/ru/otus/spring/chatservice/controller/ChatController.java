package ru.otus.spring.chatservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.chatservice.model.ChatMessage;
import ru.otus.spring.chatservice.model.ChatNotification;
import ru.otus.spring.chatservice.service.ChatMessageService;
import ru.otus.spring.chatservice.service.ChatRoomService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    @Autowired private SimpMessagingTemplate messagingTemplate;
    @Autowired private ChatMessageService chatMessageService;
    @Autowired private ChatRoomService chatRoomService;

    @MessageMapping("/chats")
    public void processMessage(@Payload ChatMessage chatMessage) {
        System.out.println("processMessage "+chatMessage);
        var chatId = chatRoomService
                .getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
            chatMessage.setChatId(chatId.get());

        System.out.println("chatId "+chatId);
        ChatMessage saved = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(),"/queue/messages",
                new ChatNotification(
                        saved.getId(),
                        saved.getSenderId(),
                        saved.getSenderName(),
                        saved.getContent()  ));


    }

    @GetMapping("/messages/counts")
    public ResponseEntity<Long> countNewMessages(
            String senderId,
            String recipientId) {
        System.out.println("messages counts "+chatMessageService.countNewMessages(senderId, recipientId) );
        return ResponseEntity
                .ok(chatMessageService.countNewMessages(senderId, recipientId));
    }

    @GetMapping("/messages/count")
    public ResponseEntity<Long> countNewMessagesAll(String recipientId) {
        return ResponseEntity.ok(chatMessageService.countNewMessagesAll(recipientId));
    }

    @GetMapping("/messages")
    public ResponseEntity<?> findChatMessages (String senderId, String recipientId) {
      return  ResponseEntity
              .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<?> findMessage ( @PathVariable String id) {
        System.out.println("findMessage "+id);
        return ResponseEntity
                .ok(chatMessageService.findById(id));
    }

    @GetMapping("/messages/getMessages")
    public ResponseEntity<?> getMessages() {
        return ResponseEntity
                .ok(chatMessageService.getChatMessages());
    }

    @GetMapping("/messages/getChatRooms")
    public ResponseEntity<?> getChatRooms () {
        return ResponseEntity
                .ok(chatRoomService.getAllChats());
    }
}
