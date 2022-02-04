package com.okta.springbootspa.restController;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.okta.springbootspa.dto.StockDto;
import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserStock;
import com.okta.springbootspa.repository.UserRepository;
import com.okta.springbootspa.repository.UserStockRepository;
import com.okta.springbootspa.dto.UserStockDto;
import com.okta.springbootspa.service.UserStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class UserStockController {
    @Autowired
    private UserStockService userStockService;
    @Autowired
    private UserStockRepository userStockRepository;
    @Autowired
    private UserRepository userRepository;



    @PostMapping("/")
    public ResponseEntity<UserStock> saveStockB(@RequestBody UserStockDto uStock) {
        User us = userRepository.findById(uStock.getId_user()).orElseThrow();
        UserStock ust = uStock.transObj(us);
       return new ResponseEntity<>(userStockRepository.save(ust), HttpStatus.CREATED);
    }

    @PostMapping("/teste/{id}")
    public ResponseEntity<StockDto> teste(@PathVariable Long id, @RequestHeader("Authorization") String token) throws Exception {
        StockDto stockDto1 = this.userStockService.teste1(id, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(stockDto1);
    }
}
