package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserStock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {

    @Query(value = "select MAX(price) from users_orders where id_stock = 3 and status = 1 and type= 1 ", nativeQuery = true)
    Double UpdateAsk_max();

    @Query(value = "select MIN(price) from user_orders where id_stock = 3 and status = 1 and type = 1 ", nativeQuery = true)
    Double UpdateAsk_min();

    @Query(value = "select MAX(price) from user_orders where id_stock = 3 and status = 1 and type = 0 ", nativeQuery = true)
    Double UpdateBid_max();

    @Query(value = "select MIN(price) from user_orders where id_stock = 3 and status = 1 and type = 0 ", nativeQuery = true)
    Double UpdateBid_min();

}