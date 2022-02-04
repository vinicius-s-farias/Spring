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
import reactor.core.publisher.Mono;

import java.util.List;

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
    public ResponseEntity<StockDto> obterPorCodigo(@PathVariable Long id,@RequestHeader("Authorization") String token) {
        StockDto userStock = this.userStockService.obterPorCodigo(id, token);
        return ResponseEntity.ok(userStock);
    }

    @PostMapping("/stocks/{id}")
    public UserStock SalvarPorCodigo(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        UserStock userStock = this.userStockService.SalvarPorCodigo(id, token);

        return userStockRepository.save(userStock);
    }
//    @PutMapping("/stocks")
//    public ResponseEntity<StockDto>Adcionar(@RequestHeader("Authorization") String token ){
//        StockDto userStock = this.userStockService.Adcionar(token);
//        return ResponseEntity.ok(userStock);
//    }

    @PostMapping("/")
    public ResponseEntity<UserStock> saveStockB(@RequestBody UserStockDto uStock) {
        User us = userRepository.findById(uStock.getId_user()).orElseThrow();
        UserStock ust = uStock.transObj(us);
       return new ResponseEntity<>(userStockRepository.save(ust), HttpStatus.CREATED);

    }

    @PutMapping("/teste/{id}")
    public ResponseEntity<StockDto> Update(@PathVariable("id") Long id, @RequestBody StockDto stock, @RequestHeader("Authorization") String token){
        StockDto stockDto = this.userStockService.obterPorCodigo(id, token);
        Double sto  = userStockRepository.UpdateAsk_max();
       StockDto st = stock.transObjStock(sto);
        stock.setAsk_max(stock.getAsk_max());
        stock.setAsk_min(stock.getAsk_min());
        stock.setBid_min(stock.getBid_min());
        stock.setBid_min(stock.getBid_min());
        return new ResponseEntity<>(userStockRepository.save(sto), HttpStatus.CREATED);
    }

}
