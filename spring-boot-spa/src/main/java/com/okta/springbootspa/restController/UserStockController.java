package com.okta.springbootspa.restController;

import com.okta.springbootspa.model.UserStock;
import com.okta.springbootspa.repository.UserStockRepository;
import com.okta.springbootspa.service.UserStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class UserStockController {
    @Autowired
    private UserStockService userStockService;
    private UserStockRepository userStockRepository;
    @Autowired
    private WebClient webClienStock;

    @GetMapping("/stocks/{id}")
    public ResponseEntity<UserStock> obterPorCodigo(@PathVariable Long id,@RequestHeader("Authorization") String token) {

        UserStock userStock = this.userStockService.obterPorCodigo(id, token);

        return ResponseEntity.ok(userStock);
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




}
