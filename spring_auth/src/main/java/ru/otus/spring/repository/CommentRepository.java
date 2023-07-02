package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.doman.Comment;

import java.time.LocalDate;

public interface CommentRepository extends MongoRepository<Comment, Long> {
    Comment findByCommentData(LocalDate date);

}
