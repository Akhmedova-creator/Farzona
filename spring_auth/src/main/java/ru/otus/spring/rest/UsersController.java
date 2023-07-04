package ru.otus.spring.rest;

import org.imgscalr.Scalr;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.chatservice.model.ChatMessage;
import ru.otus.spring.chatservice.model.ChatRoom;
import ru.otus.spring.chatservice.service.ChatMessageService;
import ru.otus.spring.chatservice.service.ChatRoomService;
import ru.otus.spring.doman.*;
import ru.otus.spring.rest.dto.FormWrapper;
import ru.otus.spring.rest.dto.UsersDto;
import ru.otus.spring.service.ServiceUsers;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class UsersController {
    private final ServiceUsers serviceUsers;
    private final ChatRoomService chatRoomService;

    private final String PATH_NAME = "src/main/resources/static/images/";
    private final String PATH_NAME_TARGET = "target/classes/static/images/";
    public UsersController(ServiceUsers serviceUsers, ChatRoomService chatRoomService, ChatMessageService chatMessageService, ChatRoomService chatRoomService1) {
        this.serviceUsers = serviceUsers;
        this.chatRoomService = chatRoomService1;
    }

    @GetMapping("/getUsers")
    public List<UsersDto> getUsers() {
        System.out.println("fara " + serviceUsers.getUsers().stream().map(UsersDto::toDto)
                .collect(Collectors.toList()));
        return serviceUsers.getUsers().stream().map(UsersDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getUsersMsg")
    public List<UsersDto> getUsersMsg(String login, String pass) {
        List<ChatRoom> chatRoom= chatRoomService.getAllChats().stream().filter(sender -> sender.getSenderId().equals(serviceUsers.getOneUser(login,pass).getId())).collect(Collectors.toList());
        System.out.println("chatRoom  "+chatRoom + " login "+login+" pass " +pass+ " id "+serviceUsers.getOneUser(login,pass).getId());
        List<String> recipientId  = chatRoom.stream().map(ChatRoom::getRecipientId).collect(Collectors.toList());
        System.out.println("recipientId  "+recipientId );

        System.out.println("fara msg " + serviceUsers.getUsers().stream().
                filter(res->recipientId .contains(res.getId())).map(UsersDto::toDto)
                .collect(Collectors.toList()));
        return serviceUsers.getUsers().stream().filter(res->recipientId .contains(res.getId())).
                map(UsersDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getOneUser")
    public Users getOneUser(String login, String pass) {
        if (serviceUsers.getUsers().stream().map(UsersDto::toDto).findFirst().isPresent())
            return serviceUsers.getOneUser(login, pass);
        else throw new RuntimeException("Cant find user");
    }




    @GetMapping("/getUsersWithFiltr")
    public List<UsersDto> getUsersWithFiltr(String fame, String job, String nationality, String town) {
        System.out.println("данные " + " " + fame + " " + job + " " + nationality + " " + town);
        System.out.println(" нашли " + serviceUsers.getUsersWithFiltr(fame, job, nationality, town));
        return serviceUsers.getUsersWithFiltr(fame, job, nationality, town).stream().map(UsersDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/saveUser")
    public void saveUsers(String login, String password, String isWoman, String age, String job, String national, String town) {
        String ROLE = "USER";
        System.out.println("данные " + login + " " + password + " " + isWoman + " " + age + " " + job + " " + national + " " + town);
        serviceUsers.saveUsers(new Users(login, password, ROLE, isWoman, age, job, national, town,null));

    }


    @PostMapping("/savePhoto")
    public void savePage(@ModelAttribute FormWrapper model) {
        String ROLE = "USER";
        System.out.println("вывод страницы " + model);
        try {
            if(model.getFile()!=null) {
                String formatOfPicture = Objects.requireNonNull(model.getFile().getOriginalFilename()).substring(model.getFile().getOriginalFilename().indexOf('.'));
                String namePhoto = model.getLogin()
                        + String.valueOf(LocalDateTime.now().atZone(ZoneId.systemDefault())
                        .toInstant().toEpochMilli()) + formatOfPicture;

                serviceUsers.saveUsers(new Users(model.getLogin(), model.getPassword(), ROLE, model.getIsWoman(),
                        model.getAge(), model.getJob(), model.getNational(), model.getTown(), namePhoto));
                saveUploadedFile(model.getFile().getBytes(), namePhoto);

                File fileInMyDirect = new File(PATH_NAME + namePhoto);
                BufferedImage newImage = scale(ImageIO.read(fileInMyDirect), fileInMyDirect, 170, 220);
                ImageIO.write(newImage, "png", fileInMyDirect);


                byte[] byteInMyDirect = Files.readAllBytes(fileInMyDirect.toPath());
                saveUploadedFile(byteInMyDirect, namePhoto);

            } else

                serviceUsers.saveUsers(new Users(model.getLogin(), model.getPassword(), ROLE, model.getIsWoman(),
                        model.getAge(), model.getJob(), model.getNational(), model.getTown(), null));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveUploadedFile(byte[] bytes, String photoName) throws IOException {
            Path path = Paths.get(PATH_NAME +photoName);
            Files.write(path, bytes);
            Path pathTar = Paths.get(PATH_NAME_TARGET +photoName);
            Files.write(pathTar, bytes);

        }


    public BufferedImage scale(BufferedImage image, File dest, int width, int height) throws IOException {
        return Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, width, height);

    }

}