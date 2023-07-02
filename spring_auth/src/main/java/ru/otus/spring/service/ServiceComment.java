package ru.otus.spring.service;

import ru.otus.spring.doman.Comment;

import java.time.LocalDate;

public interface ServiceComment {
    Comment getCommentByDate(LocalDate date);
}
