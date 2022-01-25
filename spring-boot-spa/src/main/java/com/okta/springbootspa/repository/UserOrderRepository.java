package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.User;
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

    @Query(value = "SELECT * FROM users_orders WHERE type = 1 and id_stock = ?1 and status = 1", nativeQuery = true)
    List<UserOrder> findByTypeStock(Long id_stock);

    @Query(value = "SELECT * FROM users_orders a, users_orders b  where a.type <> b.type  and a.id_stock = b.id_stock ", nativeQuery = true)
    List<UserOrder> findByCalculo();

    @Modifying
    //@Query(value = "update user_orders  set remaining_value = (SELECT MAX(a.volume) - MIN(b.volume) AS ID FROM user_orders a, user_orders b  WHERE a.type = 1  and a.id_stock = b.id_stock) where type =  1 AND id=?1", nativeQuery = true)
    @Query(value = "update users_orders  set remaining_value = (SELECT MAX(a.volume) - MIN(b.volume)AS ID FROM users_orders a, users_orders b  WHERE a.type <> b.type  and a.id_stock = b.id_stock and a.id_order=?1) where type =  1 AND id_order=?1", nativeQuery = true)
    int updateRemainingValue(UserOrder id_order);

    @Query(value = "SELECT * FROM users_orders where status = 1 and type = 1", nativeQuery = true)
    List<UserOrder> findByStatus();

    @Modifying
    @Query(value = "UPDATE users_orders SET status = 2 WHERE id_order = ?1 and remaining_value = 0 ", nativeQuery = true)
    int updateStatus(UserOrder id_order);

    @Modifying
    @Query(value = "update users u set dollar_balance = (SELECT (uo.price * uo.volume) + dollar_balance FROM users_orders uo inner join users u on uo.id_user = u.id  where uo.status = 2 and uo.id_user = ?1) where u.id = ?1", nativeQuery = true)
    int updateDollarBalance (User user);

    @Modifying
    @Query(value = "UPDATE users_orders SET status = 3 WHERE id_order = ?1 and remaining_value = 0 ", nativeQuery = true)
    int updateStatus2(UserOrder id_order);
}







