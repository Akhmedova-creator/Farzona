package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Comment;
import ru.otus.spring.repository.CommentRepository;

import java.time.LocalDate;

@Service
public class ServiceCommentImpl implements ServiceComment {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment getCommentByDate(LocalDate date) {
        return commentRepository.findByCommentData(date);
    }
}
