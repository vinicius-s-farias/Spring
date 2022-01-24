package com.Rest.API.repository;

import com.Rest.API.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Modifying
    @Query(value = "UPDATE stocks SET ask_min = ?1 WHERE id = ?1", nativeQuery = true)
    int updateStatus(Double ask_min,Stock id);

}
