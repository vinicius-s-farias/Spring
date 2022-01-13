package com.Rest.API.controller;

import java.util.List;

import com.Rest.API.model.Stock;
import com.Rest.API.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.controller;

@RestController

public class StockController {

     @Autowired
     private StockRepository stockRepository;

     @GetMapping("/stocks")
     public List<Stock> listar() {
         return stockRepository.findAll();

     }

     @PostMapping("/stocks")
     public Stock adicionar(@RequestBody Stock stock) {
         return stockRepository.save(stock);
     }
}
