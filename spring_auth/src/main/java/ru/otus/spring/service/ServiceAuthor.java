package ru.otus.spring.service;

import ru.otus.spring.doman.Author;

import java.util.List;
import java.util.Optional;

public interface ServiceAuthor {
    List<Author> getAuthors();

    Author findByFirstName(String name);

    Optional<Author> findByIdAuthor(String id);
}
