package com.okta.springbootspa.restController;

import java.sql.SQLException;
import java.util.List;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.model.UserStock;
import com.okta.springbootspa.repository.UserOrderRepository;

import com.okta.springbootspa.repository.UserRepository;
import com.okta.springbootspa.dto.UserOrderDto;
import com.okta.springbootspa.service.UserStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class UserOrderController {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserStockService userStockService;

    @GetMapping("/usersorders")
    public List<UserOrder> listar() {
        return userOrderRepository.findAll();
    }

    @PostMapping("/order")
    public ResponseEntity<UserOrder> criaOrdem(@RequestBody UserOrderDto dto ,@RequestHeader("Authorization") String token) {
        User user = userRepository.findById(dto.getId_user()).orElseThrow();
        Double dollar = user.getDollar_balance();
        Double mult = dto.getPrice() * dto.getVolume();
        if(dollar >= mult) {
            UserOrder userOrders = userOrderRepository.save(dto.transObj(user));
            userStockService.teste1(userOrders.getId_stock(), token);
            return new ResponseEntity<>(userOrders, HttpStatus.CREATED);
        } else {
            System.out.println("Ordem não criada, valor insuficiente");
        }
        return null;
    }

}




