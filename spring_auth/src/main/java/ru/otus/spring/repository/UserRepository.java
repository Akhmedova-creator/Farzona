package ru.otus.spring.repository;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.Nullable;
import ru.otus.spring.doman.Users;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends MongoRepository<Users, Long> {
    Users findByLogin(String name);
    Optional<Users> findById(String id);
    Users findFirstByLoginAndPassword(String login, String password);

    void deleteByLoginAndPassword(String login, String password);
}


