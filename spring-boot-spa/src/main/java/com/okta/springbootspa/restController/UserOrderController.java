package com.okta.springbootspa.restController;

import java.util.List;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.UserOrderRepository;

import com.okta.springbootspa.repository.UserRepository;
import com.okta.springbootspa.dto.UserOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserOrderController {

    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/usersorders")
    public List<UserOrder> listar() {
        return userOrderRepository.findAll();

    }

    @PostMapping("/order")
    public ResponseEntity<UserOrder> saveStockB(@RequestBody UserOrderDto uOrder) {
        User us = userRepository.findById(uOrder.getId_user()).orElseThrow();
        UserOrder uso = uOrder.transObj(us);
        return new ResponseEntity<>(userOrderRepository.save(uso), HttpStatus.CREATED);
//        return userStockRepository.save(ust);
    }
}
