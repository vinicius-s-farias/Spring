package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserStock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {

}
