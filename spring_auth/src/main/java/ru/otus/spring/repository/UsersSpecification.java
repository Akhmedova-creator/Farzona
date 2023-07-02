package ru.otus.spring.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.otus.spring.doman.Users;
@Component
public class UsersSpecification implements Specification <Users> {
    @Override
    public javax.persistence.criteria.Predicate toPredicate(javax.persistence.criteria.Root<Users> root, javax.persistence.criteria.CriteriaQuery<?> query, javax.persistence.criteria.CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("job"), "%"+"программист"+"%");
    }


}
