package com.okta.springbootspa.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/users")
    public List<User> listar() {
        return UserRepository.findAll();

    }

    @PostMapping("/users")
    public User adicionar(@RequestBody User user) {
        return UserRepository.save(user);
    }
}
