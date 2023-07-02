package ru.otus.spring.service;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.doman.Users;
import ru.otus.spring.repository.UserRepository;
import ru.otus.spring.repository.UsersSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsersImpl implements ServiceUsers {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UsersSpecification usersSpecification;


    @Transactional
    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public Users findByLogin(String name) {
        return userRepository.findByLogin("fara");
    }

    @Override
    public Optional<Users> findByIdUser(String id) {
      return userRepository.findById(id);
    }

    @Override
    public List<Users> getUsersWithFiltr(String fame, String job, String national , String town ) {
        Users users = new Users();
        if(!job.equals("все"))
        users.setJob(job);
        if(!fame.equals("все"))
        users.setFemale(fame);
        if(!national.equals("все"))
        users.setNationality(national);
        if(!town.equals("все"))
        users.setTown(town);
        Example<Users> example = Example.of(users);
       return  userRepository.findAll(example);
    }

    @Override
    public Users saveUsers(Users users) {
        if(userRepository.findFirstByLoginAndPassword(users.getLogin(), users.getPassword())!=null){
          userRepository.deleteByLoginAndPassword(users.getLogin(), users.getPassword());
        }
        return userRepository.save(users);
    }



    public Users getOneUser(String login ,String pass){
        System.out.println("fara "+userRepository.findFirstByLoginAndPassword(login, pass));
        return userRepository.findFirstByLoginAndPassword(login, pass);
    }

}
