package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserOrder;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    //@Query(value = "SELECT * FROM user_orders WHERE type = 1 and id_stock = ?1 and status = 1", nativeQuery = true)
    @Query(value = "SELECT volume, type FROM user_orders WHERE type = 1 and id_stock = ?1 and status = 1", nativeQuery = true)
    List<UserOrder> findByTypeStock(Long id_stock);


    @Query(value = "SELECT MAX(a.volume) - MIN(b.volume)  AS ID FROM user_orders a, user_orders b  WHERE a.id=?1 AND a.type <> b.type", nativeQuery = true)
    List<UserOrder> findByCalculo(Long id);

    @Modifying
    @Query(value = "update user_orders set remaining_value = ?1", nativeQuery = true)
    int updateRemainingValue(UserOrder remaining_value);


    @Modifying
    @Query(value = "UPDATE user_orders SET status = 2 WHERE id = ?1 ", nativeQuery = true)
    int updateStatus(UserOrder id);

}





