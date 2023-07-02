package ru.otus.spring.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.doman.Author;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, Long> {
    Author findByFirstName(String name);

    Optional<Author> findById(String id);
}
