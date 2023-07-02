package ru.otus.spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Document("age")
@Data
public class Age {

    @Id
    private String id;

    @Field("age")
    private Integer age;

    public Age (Integer age) {
        this.age = age;
    }
}
