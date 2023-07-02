package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

;

@Service
public class ServiceGenreImpl implements ServiceGenre {
    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    @Override
    public Genre getGenreName(String name) {
        return genreRepository.findByName(name);
    }

    @Transactional
    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findByIdGenre(String id) {
        return genreRepository.findById(id);
    }
}
