package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.rest.dto.AuthorDto;
import ru.otus.spring.service.ServiceAuthor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private final ServiceAuthor serviceAuthor;

    public AuthorController(ServiceAuthor serviceAuthor) {
        this.serviceAuthor = serviceAuthor;
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors() {
        return serviceAuthor.getAuthors().stream().map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }
}
