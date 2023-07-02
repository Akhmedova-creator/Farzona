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
@Document(collection = "job")
public class Job {
    @Id
    private String id;

    @Field("job")
    private String job;

    public Job(String job) {
        this.job = job;
    }
}
