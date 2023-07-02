package ru.otus.spring.chatservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.chatservice.model.ChatRoom;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
    List<ChatRoom> findAll();
    Boolean existsBySenderId(String senderId);
}
