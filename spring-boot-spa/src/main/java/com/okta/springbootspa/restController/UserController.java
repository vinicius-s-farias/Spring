package com.okta.springbootspa.restController;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    @DeleteMapping("/users")
    public void deletaUser(@RequestBody User user){
        userRepository.delete(user);
    }
    @PutMapping("/users")
    public User atualizaUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
