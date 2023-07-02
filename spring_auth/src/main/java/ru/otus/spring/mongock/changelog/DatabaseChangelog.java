package ru.otus.spring.mongock.changelog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import ru.otus.spring.doman.*;
import ru.otus.spring.repository.AuthorRepository;
import ru.otus.spring.repository.BookRepository;
import ru.otus.spring.repository.GenreRepository;
import ru.otus.spring.repository.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "002", id = "addAuthors", author = "AkhmedovaFI")
    public void insertAuthors(UserRepository userRepository) {
        try {
            userRepository.save(new Users("Admin","12345","ADMIN","женский", "29","программист","таджикская","Екатеринбург","Admin12345.png"));
            userRepository.save(new Users("best_woman","12345","USER","женский", "35","врач", "русская", "Москва","best_woman12345.png"));
            userRepository.save(new Users("lovely","12345","USER","женский", "21","модель", "башкирская", "Казань","lovely12345.png"));
            userRepository.save(new Users("handsome","12345","USER", "мужской", "24","бизнесмен","узбекская","Новосибирск","handsome12345.png"));
            userRepository.save(new Users("Beha","12345","USER","мужской", "25","инженер", "русская", "Владивосток","Beha12345.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}