package ru.otus.spring.doman;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.nio.Buffer;

@Setter
@Getter
@Data
@AllArgsConstructor
@Document(collection = "photos")
public class Photos {
    @Id
    private String id;

    @Field("photoWho")
    private String photoWho;

    @Field("photoName")
    private String photoName;

}
