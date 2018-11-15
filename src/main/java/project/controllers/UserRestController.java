package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.module.User;
import project.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/list")
public class UserRestController {

    @Autowired
    UserService userServiceDB;

    @CrossOrigin
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userServiceDB.listUser();
    }

}
