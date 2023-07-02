package ru.otus.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.rest.dto.GenreDto;
import ru.otus.spring.service.ServiceGenre;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenreController {
    private final ServiceGenre serviceGenre;

    public GenreController(ServiceGenre serviceGenre) {
        this.serviceGenre = serviceGenre;
    }

    @GetMapping("/genres")
    public List<GenreDto> getGenres() {
        return serviceGenre.getGenres().stream().map(GenreDto::toDto)
                .collect(Collectors.toList());
    }
}
