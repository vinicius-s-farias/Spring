package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {

    @Query(value = "select MAX(price) from users_orders where id_stock = ?1 and status = 1 and type = 1", nativeQuery = true)
    Double getAskMax(Long id_stock);

    @Query(value = "select MIN(price) from users_orders where id_stock = ?1 and status = 1 and type = 1", nativeQuery = true)
    Double getAskMin(Long id_stock);

    @Query(value = "select MAX(price) from users_orders where id_stock = ?1 and status = 1 and type = 0 ", nativeQuery = true)
    Double getBidMax(Long id_stock);

    @Query(value = "select MIN(price) from users_orders where id_stock = ?1 and status = 1 and type = 0", nativeQuery = true)
    Double getBidMin(Long id_stock);
}