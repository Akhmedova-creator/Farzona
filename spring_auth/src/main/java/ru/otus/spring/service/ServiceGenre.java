package ru.otus.spring.service;

import ru.otus.spring.doman.Genre;

import java.util.List;
import java.util.Optional;

public interface ServiceGenre {
    Genre getGenreName(String name);

    List<Genre> getGenres();

    Optional<Genre> findByIdGenre(String id);
}
