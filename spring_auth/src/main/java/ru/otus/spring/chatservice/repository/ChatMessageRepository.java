package ru.otus.spring.chatservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.chatservice.model.ChatMessage;
import ru.otus.spring.chatservice.model.MessageStatus;

import java.util.List;

public interface ChatMessageRepository
        extends MongoRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
    List<ChatMessage> findAll();
    long countByStatusAndAndRecipientId(MessageStatus status, String recipientId );
}