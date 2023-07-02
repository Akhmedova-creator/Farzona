package ru.otus.spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Document("female")
@Data
public class Female {

    @Id
    private String id;

    @Field("isWoman")
    private String isWoman;

    public Female(String isWoman) {
        this.isWoman = isWoman;
    }
}
