package ru.otus.spring.doman;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.nio.Buffer;
@Builder
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class Users {

    @Id
    private String id;

    @Field("login")
    private String login;

    @Field("password")
    private String password;

    @Field("role")
    private String role;

    @Field("female")
    private String female;

    @Field("age")
    private String age;

    @Field("job")
    private String job;

    @Field("nationality")
    private String nationality;

    @Field("town")
    private String town;

    @Field("photoName")
    private String photoName;


    public Users(String login, String password, String role , String female, String age, String job, String nationality, String town, String photoName) {
        this.login = login;
        this.password = password;
        this.role =role;
        this.female =female;
        this.age = age;
        this.job=job;
        this.nationality =nationality;
        this.town = town;
        this.photoName = photoName;
    }



    @Override
    public String toString() {
        return   login + " "+password +" "+role+ " "+female + " "+age + " "+ job + " "+ nationality + " "+town+" "+photoName;
    }
}
