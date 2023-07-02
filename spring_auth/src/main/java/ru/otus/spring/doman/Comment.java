package ru.otus.spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Document("comment")
@Data
public class Comment {

    @Id
    private String id;

    @Field("commentname")
    private String commentName;

    @Field("commentdata")
    private LocalDate commentData;

    @Field
    private Book book;

    public Comment(String commentName, LocalDate commentData, Book book) {
        this.commentName = commentName;
        this.commentData = commentData;
        this.book = book;
    }
}

