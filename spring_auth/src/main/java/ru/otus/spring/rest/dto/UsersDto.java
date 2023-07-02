package ru.otus.spring.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.doman.Users;
import ru.otus.spring.repository.UserRepository;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private  String id;
    private String login;
    private String isWoman;
    private String age;
    private String job;
    private String national;
    private String town;
    private String password;
    private String photoName;



    public static UsersDto toDto(Users users) {
        UsersDto usersDto = new UsersDto(users.getId(), users.getLogin(),users.getFemale(),
                users.getAge(), users.getJob(),users.getNationality(),
                users.getTown(), users.getPassword(), users.getPhotoName());
        return usersDto;
    }


}

