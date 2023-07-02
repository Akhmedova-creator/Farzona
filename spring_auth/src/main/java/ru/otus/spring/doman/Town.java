package ru.otus.spring.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Document("town")
@Data
public class Town {
    @Id
    private String id;

    @Field("town")
    private String town;

    public Town(String town) {
        this.town =town;
    }
}
