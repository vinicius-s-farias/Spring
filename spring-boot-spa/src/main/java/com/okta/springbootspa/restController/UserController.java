package com.okta.springbootspa.restController;

import java.util.List;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> listar() {
        return userRepository.findAll();

    }

    @PostMapping("/users")
    public User adicionar(@RequestBody User user) {
        return userRepository.save(user);
    }
}
