package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.doman.Genre;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private String name;
    private String id;

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getName(),
                genre.getId());
    }

}
