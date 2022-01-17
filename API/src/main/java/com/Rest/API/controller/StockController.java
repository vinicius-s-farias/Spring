package com.Rest.API.controller;

import java.util.List;
import java.util.Optional;

import com.Rest.API.model.Stock;
import com.Rest.API.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.controller;

@RestController

public class StockController {

     @Autowired
     private StockRepository stockRepository;

    @GetMapping("/stocks/{id}")
    public Optional<Stock> obterStock(@PathVariable (value = "id")Long id) throws Exception {
        Thread.sleep(3000);
        return stockRepository.findById(id);
    }

     @GetMapping("/stocks")
     public List<Stock> listar()  {
         return stockRepository.findAll();
     }

     @PostMapping("/stocks")
     public Stock adicionar(@RequestBody Stock stock) {
         return stockRepository.save(stock);


     }
}
