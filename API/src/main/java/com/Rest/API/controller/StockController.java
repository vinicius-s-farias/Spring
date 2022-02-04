package com.Rest.API.controller;

import java.util.List;
import java.util.Optional;

import com.Rest.API.dto.StockDto;
import com.Rest.API.model.Stock;
import com.Rest.API.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.controller;

@RestController
public class StockController {

     @Autowired
     private StockRepository stockRepository;

    @PostMapping("/teste")
    public ResponseEntity<?> teste(@RequestBody StockDto stockDto){
        Stock stock = stockRepository.findById(stockDto.getId()).orElseThrow();
        if(stockDto.getAsk_max() != null) {
            stock.setAsk_max(stockDto.getAsk_max());
            stock.setAsk_min(stockDto.getAsk_min());
        }
        if (stockDto.getBid_min() != null) {
            stock.setBid_max(stockDto.getBid_max());
            stock.setBid_min(stockDto.getBid_min());
        }
        return new ResponseEntity<>(stockRepository.save(stock), HttpStatus.CREATED);
    }
}

