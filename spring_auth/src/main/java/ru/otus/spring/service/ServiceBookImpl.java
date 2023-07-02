package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBookImpl implements ServiceBook {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public List<Book> getBooksByGenreAndAuthors(Genre genre, Author author) {
        return bookRepository.findByGenreAndAuthor(genre,
                author);
    }

    @Override
    public Optional<Book> findByIdBook(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

}
