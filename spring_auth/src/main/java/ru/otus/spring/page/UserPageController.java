package ru.otus.spring.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.spring.service.ServiceUsers;

@Controller
public class UserPageController {


    @GetMapping("/login")
    public String pageList() {
        return "login";
    }

    @GetMapping("/mems")
    public String memsList() {
        return "mems";
    }

    @GetMapping("/chat/{id}/{login}")
    public String chatPage(@PathVariable String id,@PathVariable String login, Model model) {
        model.addAttribute("id",id);
        model.addAttribute("login",login);
        return "chat";
    }

    @GetMapping("/registration")
    public String pageRegistration() {
        return "registration";
    }

    @GetMapping("/users")
    public String pageUsers() {
        return "users";
    }

    @GetMapping("/edit")
    public String pageEdit() {
        return "edit";
    }

}
