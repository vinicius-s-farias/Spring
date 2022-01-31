package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface VendaRepository extends JpaRepository<UserOrder, Long> {

    @Query(value = "SELECT * FROM users_orders WHERE type = 1 and id_stock = ?1 and status = 1", nativeQuery = true)
    List<UserOrder> findByTypeStock2(Long id_stock);

    @Query (value = " select * from " +
            "users_orders a, users_orders b where a.remaining_value < b.volume and a.type = 1", nativeQuery = true)
    List<UserOrder> findByCalculo2();

    @Modifying
    @Query(value = " update users_orders  set remaining_value = (select (MAX(a.remaining_value ) - MIN(b.remaining_value)) from " +
            "  users_orders a, users_orders b where  a.type =1 ) where id_order=?1 and type = 1",nativeQuery = true )
    int updateRemainingValue2(UserOrder id_order);


    @Modifying
    @Query(value = "UPDATE users_orders SET status = 1 WHERE id_order = ?1 and remaining_value <> volume", nativeQuery = true)
    int updateStatus(UserOrder id_order);

    @Modifying
    @Query(value = "UPDATE users_orders SET status = 2 WHERE id_order = ?1 and remaining_value = 0 ", nativeQuery = true)
    int updateStatus2(UserOrder id_order);

    @Modifying
    @Query(value = "update users set dollar_balance = (select a.volume  * uo.price + u.dollar_balance " +
            "FROM users_orders a, users_orders uo " +
            "inner join users u on uo.id_user = u.id " +
            "where a.status = 1  and a.id_stock = uo.id_stock and a.type = 0  and a.status = uo.status and uo.id_order <> a.id_order and u.id = 1) where id = 1", nativeQuery = true)
    int updateDollarBalance2 (User user);

    @Query(value = "SELECT * from users_orders where status =1 and type = 1 ", nativeQuery = true)
    List<UserOrder> findByStatus2();


    @Modifying
    @Query(value = "update users_stocks_balances set volume = ( " +
            " select usb.volume - (a.volume - uo.volume) " +
            " AS ID FROM users_orders a, users_orders uo " +
            " inner join users u on uo.id_user = u.id " +
            " inner join users_stocks_balances usb on u.id = usb.id_user " +
            " WHERE a.type <> uo.type  and a.id_stock = uo.id_stock and a.id_order= 10 " +
            " ) where id_user = ?1 and id_stock = ?2",nativeQuery = true)
    int atualizarBalance2(User id_user, Long id_stock);



    @Query(value = "select * from " +
            "           users_orders a, users_orders b where  a.remaining_value < b.volume and a.type = 1 and a.status = 1", nativeQuery = true)
    List<UserOrder>findtTesteN();


    @Modifying
    @Query(value = "update users set dollar_balance =  dollar_balance +( " +
            "select a.remaining_value  * a.price " +
            "fROM users_orders a, users_orders uo " +
            "where  a.id_stock = uo.id_stock and a.type = 1  and uo.id_order <> a.id_order and a.id_order = ?1 " +
            ") where id = ?2", nativeQuery = true)
    int updateDollarBalance1 (UserOrder id_order, User user);


}
