package com.example.demo.Controllers;


import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiUser")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{username}")
    public Collection<User>  getUser(@PathVariable String username){
        return userRepository.findUserByUsername(username);
    }
}
