package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.doman.Author;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;
    private String id;

    public static AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto(author.getFirstName() + " " + author.getLastName(),
                author.getId());
        return authorDto;
    }
}

