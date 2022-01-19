package com.okta.springbootspa.restController;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserStock;
import com.okta.springbootspa.repository.UserRepository;
import com.okta.springbootspa.repository.UserStockRepository;
import com.okta.springbootspa.restController.dto.UserStockDto;
import com.okta.springbootspa.service.UserStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@RestController
public class UserStockController {
    @Autowired
       private UserStockService userStockService;
    @Autowired
    private UserStockRepository userStockRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WebClient webClienStock;

    @GetMapping("/stocks/{id}")
    public ResponseEntity<UserStock> obterPorCodigo(@PathVariable Long id,@RequestHeader("Authorization") String token) {

        UserStock userStock = this.userStockService.obterPorCodigo(id, token);

        return ResponseEntity.ok(userStock);
    }
    @PostMapping("/stocks/{id}")
    public UserStock SalvarPorCodigo(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        UserStock userStock = this.userStockService.SalvarPorCodigo(id, token);

        return userStockRepository.save(userStock);
    }

    @GetMapping("/teste")
    public List<UserStock> listar()  {
        return userStockRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<UserStock> saveStockB(@RequestBody UserStockDto uStock) {
        User us = userRepository.findById(uStock.getId_user()).orElseThrow();
        UserStock ust = uStock.transObj(us);
       return new ResponseEntity<>(userStockRepository.save(ust), HttpStatus.CREATED);
//        return userStockRepository.save(ust);
    }
//
//    WebClient.build().get().uri("http://localhost:8082/stocks/" id_stock)
//    .retrieve()
//    .bodytoMono(UserStock.class)
//    .block();
//
//    @GetMapping("/stocks/{id}/userstock")
//    public ResponseEntity<UserStock> obterPorCodigo(@PathVariable Long id_stock) {
//        UserStock userStock = this.userStockService.obterPorCodigo(id_stock);
//
//        return ResponseEntity.ok(userStock);
//    }

//    @GetMapping("/stocks")
//    public List<UserStock> listar() {
//        return userStockRepository.findAll();
//
//    }
//
//
//    @PostMapping("/userstock")
//    public UserStock adicionar(@RequestBody UserStock userstock) {
//
//    return userStockRepository.save(userstock);
//    }
//    }
//
//     u.setUser(us);
//        u.setId(uStock.getId_stock());
//        u.setStock_name(uStock.getStock_name());
//        u.setStock_symbol(uStock.getStock_symbol());
//        u.setVolume(uStock.getVolume());


}
