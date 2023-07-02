package ru.otus.spring.service;


import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;

import java.util.List;
import java.util.Optional;

public interface ServiceBook {
    List<Book> getBooks();

    List<Book> getBooksByGenreAndAuthors(Genre genre, Author author);

    Optional<Book> findByIdBook(String id);

    Book saveBook(Book book);

    void deleteBook(Book book);
}
