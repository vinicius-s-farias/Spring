package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserStock;

import com.okta.springbootspa.restController.dto.UserStockDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {

    @Modifying
    @Query(value = "insert into users_stocks_balances(id_user, id, stock_name,stock_symbol, volume)  VALUES ('?', '?', '?', '?', '?')", nativeQuery = true)
    @Transactional
    void logURI(@Param("id_user") Long id_user, @Param("id") Long id, @Param("stock_name") String  stock_name, @Param("stock_symbol") String stock_symbol,@Param("volume") Long volume);

}