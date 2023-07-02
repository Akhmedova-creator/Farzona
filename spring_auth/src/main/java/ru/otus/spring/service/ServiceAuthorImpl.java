package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Author;
import ru.otus.spring.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAuthorImpl implements ServiceAuthor {
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    @Override
    public Author findByFirstName(String name) {
        return authorRepository.findByFirstName("Хорстман");
    }

    @Override
    public Optional<Author> findByIdAuthor(String id) {
        return authorRepository.findById(id);
    }
}
