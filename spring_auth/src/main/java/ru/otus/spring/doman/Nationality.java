package ru.otus.spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "nationality")
public class Nationality {
    @Id
    private String id;

    @Field("national")
    private String national;

    public Nationality(String national) {
        this.national = national;
    }
}
