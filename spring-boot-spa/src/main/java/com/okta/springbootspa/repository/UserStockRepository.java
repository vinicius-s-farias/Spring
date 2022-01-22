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

    @Modifying
    @Query(value = "insert into users_stocks_balances(id_user, id, stock_name,stock_symbol, volume)  VALUES ('?', '?', '?', '?', '?')", nativeQuery = true)
    @Transactional
    void logURI(@Param("id_user") Long id_user, @Param("id") Long id, @Param("stock_name") String  stock_name, @Param("stock_symbol") String stock_symbol,@Param("volume") Long volume);

}