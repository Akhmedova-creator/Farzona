package ru.otus.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.spring.doman.Book;

@Component
public class BookCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        if (source instanceof Book) {
            if (((Book) source).getAuthor() != null) {
                mongoOperations.save(((Book) source).getAuthor());
            }

            if (((Book) source).getGenre() != null)
                mongoOperations.save(((Book) source).getGenre());
        }
    }
}
