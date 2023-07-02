package ru.otus.spring.rest;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.rest.dto.BookDto;
import ru.otus.spring.service.ServiceAuthor;
import ru.otus.spring.service.ServiceBook;
import ru.otus.spring.service.ServiceGenre;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@RestController
public class BookController {
    private final ServiceBook serviceBook;
    private final ServiceAuthor serviceAuthor;
    private final ServiceGenre serviceGenre;

    @GetMapping("/api/books")
    public List<BookDto> listBook() {
        return serviceBook.getBooks().stream().map(BookDto::toDto)
                .collect(Collectors.toList());

    }

    @GetMapping("/delete/{id}")
    public String deleteBook(Model model, @PathVariable String id) {
        Book book = serviceBook.findByIdBook(id).orElseThrow(NotFoundException::new);
        serviceBook.deleteBook(book);
        model.addAttribute("book",
                serviceBook.getBooks());
        return "успешно удалена книга";
    }

    @PostMapping("/saveBooks")
    public Book save(String title, String idGenre, String idAuthor) {
        Genre genre = serviceGenre.findByIdGenre(idGenre).orElseThrow(NotFoundException::new);
        Author author = serviceAuthor.findByIdAuthor(idAuthor).orElseThrow(NotFoundException::new);
        Book save = new Book();
        save.setTitle(title);
        save.setGenre(genre);
        save.setAuthor(author);
        return serviceBook.saveBook(save);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlNotFind(NotFoundException handlNotFind) {
        return ResponseEntity.badRequest().body("Not find entity");
    }
}
