package ru.otus.spring.chatservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ru.otus.spring.chatservice.exception.ResourceNotFoundException;
import ru.otus.spring.chatservice.model.ChatMessage;
import ru.otus.spring.chatservice.model.MessageStatus;
import ru.otus.spring.chatservice.repository.ChatMessageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {
    @Autowired private ChatMessageRepository repository;
    @Autowired private ChatRoomService chatRoomService;
    @Autowired private MongoOperations mongoOperations;

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }

    public long countNewMessages(String senderId, String recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    }

    public long countNewMessagesAll(String recipientId) {
        return repository.countByStatusAndAndRecipientId(MessageStatus.RECEIVED,recipientId);
    }
    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);
        System.out.println("chatId "+chatId);
        var messages =
                chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());
        System.out.println("messages "+messages);
        if(messages.size() > 0) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
        }

        return messages;
    }

    public ChatMessage findById(String id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
                    return repository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new ResourceNotFoundException("can't find message (" + id + ")"));
    }

    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
        Query query = new Query(
                Criteria
                        .where("senderId").is(senderId)
                        .and("recipientId").is(recipientId));
        Update update = Update.update("status", status);
        mongoOperations.updateMulti(query, update, ChatMessage.class);
    }

    public List<ChatMessage> getChatMessages (){
        return repository.findAll();
    }
}
