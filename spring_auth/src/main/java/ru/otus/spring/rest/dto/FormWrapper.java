package ru.otus.spring.rest.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FormWrapper {
    private MultipartFile file;
    private String  login;
    private String password;
    private String isWoman;
    private String age;
    private String job;
    private String national;
    private String town;
}
