package com.okta.springbootspa.restController;

import java.util.List;

import com.okta.springbootspa.model.UserStock;
import com.okta.springbootspa.repository.UserStockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserStockController {

    @Autowired
    private UserStockRepository userStockRepository;

    @GetMapping("/userstock")
    public List<UserStock> listar() {
        return userStockRepository.findAll();

    }

    @PostMapping("/userstock")
    public UserStock adicionar(@RequestBody UserStock userstock) {
        return userStockRepository.save(userstock);
    }
}
