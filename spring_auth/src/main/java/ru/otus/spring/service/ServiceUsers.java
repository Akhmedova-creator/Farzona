package ru.otus.spring.service;

import org.apache.catalina.User;
import ru.otus.spring.doman.Users;

import java.util.List;
import java.util.Optional;

public interface ServiceUsers {
    List<Users> getUsers();

    Users findByLogin(String name);

    Optional<Users> findByIdUser(String id);
    List<Users> getUsersWithFiltr(String fame, String job, String national , String town);

    Users saveUsers(Users users);
    Users getOneUser(String login , String pass);

}
