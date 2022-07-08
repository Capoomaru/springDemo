package com.delisting.demo.web;

import com.delisting.demo.domain.users.UsersRepository;
import com.delisting.demo.service.posts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService usersRepository) {
        this.userService = usersRepository;
    }

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }
}
