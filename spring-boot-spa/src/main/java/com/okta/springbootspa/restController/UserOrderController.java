package com.okta.springbootspa.restController;

import java.util.List;

import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.UserOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserOrderController {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @GetMapping("/usersorders")
    public List<UserOrder> listar() {
        return userOrderRepository.findAll();

    }

    @PostMapping("/usersorders")
    public UserOrder adicionar(@RequestBody UserOrder userorder) {
        return userOrderRepository.save(userorder);
    }
}
