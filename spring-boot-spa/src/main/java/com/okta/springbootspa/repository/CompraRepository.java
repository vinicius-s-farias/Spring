package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompraRepository extends JpaRepository<UserOrder, Long > {

    @Query(value = "SELECT volume, type, id FROM user_orders WHERE type = 1 and id_stock = ?1 and status = 1", nativeQuery = true)
    List<UserOrder> findByTypeStock(Long id_stock);

    @Query(value = "SELECT * FROM user_orders a, user_orders b  where a.type <> b.type  and a.id_stock = b.id_stock ", nativeQuery = true)
    List<UserOrder> findByCalculo();

    @Modifying
    //@Query(value = "update user_orders  set remaining_value = (SELECT MAX(a.volume) - MIN(b.volume) AS ID FROM user_orders a, user_orders b  WHERE a.type = 1  and a.id_stock = b.id_stock) where type =  1 AND id=?1", nativeQuery = true)
    @Query(value = "update user_orders  set remaining_value = (SELECT MAX(a.volume) - MIN(b.volume)AS ID FROM user_orders a, user_orders b  WHERE a.type <> b.type  and a.id_stock = b.id_stock and a.id=?1) where type =  1 AND id=?1", nativeQuery = true)
    int updateRemainingValue(UserOrder id);

    @Modifying
    @Query(value = "UPDATE user_orders SET status = 2 WHERE id = ?1 and remaining_value = 0 ", nativeQuery = true)
    int updateStatus(UserOrder id);

    @Modifying
    @Query(value = "update users set dollar_balance = (select SUM((price  * volume)+ dollar_balance) AS total FROM user_orders uo inner join users u on uo.id_user = u.id where uo.id  = ?1) where id = ?2", nativeQuery = true)
    int updateDollarBalance (UserOrder id, User id1);

    @Query(value = "SELECT * FROM user_orders   where status = 2 ", nativeQuery = true)
    List<UserOrder> findByStatus();

}
