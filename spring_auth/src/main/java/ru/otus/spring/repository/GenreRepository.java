package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.doman.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, Integer> {
    Genre findByName(String name);

    List<Genre> findAll();

    Optional<Genre> findById(String id);
}
