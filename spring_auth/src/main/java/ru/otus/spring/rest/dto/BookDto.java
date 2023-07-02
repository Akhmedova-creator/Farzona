package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;

import java.util.function.DoubleToIntFunction;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;

    private String title;

    private String genre;

    private String author;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(),
                book.getTitle(),
                book.getGenre().getName(),
                book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
    }
}
