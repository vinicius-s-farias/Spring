package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompraRepository extends JpaRepository<UserOrder, Long > {

    @Query(value = "SELECT * FROM users_orders WHERE type = 0 and id_stock = ?1 and status = 1", nativeQuery = true)
    List<UserOrder> findByTypeStock(Long id_stock);
    // Procura compras

    @Query(value = "SELECT * FROM users_orders a, users_orders b  where a.type <> b.type  and a.id_stock = b.id_stock and a.status = b.status ", nativeQuery = true)
    List<UserOrder> findByCalculo();

    @Modifying
    @Query(value = "update users_orders  set remaining_value = (SELECT MAX(b.remaining_value) - MIN(b.volume)AS ID FROM users_orders a, users_orders b  WHERE a.type <> b.type  and a.id_stock = b.id_stock and a.id_order=?1) where type =  0 AND id_order=?1", nativeQuery = true)
    int updateRemainingValue(UserOrder id_order);
    //Ele atualiza o raimaning value conforme compras são realizadas

    @Modifying
    @Query(value = "UPDATE users_orders SET status = 2 WHERE id_order = ?1 and remaining_value = 0", nativeQuery = true)
    int updateStatus(UserOrder id_order);

//    @Modifying
//    @Query(value = "UPDATE users_orders SET status = 3 WHERE id_order = ?1 and remaining_value = 0 ", nativeQuery = true)
//    int updateStatus2(UserOrder id_order);

    @Modifying
    @Query(value = "update users set dollar_balance = (select  u.dollar_balance - a.remaining_value  * uo.price  "   + " FROM users_orders a, users_orders uo " +
            "inner join users u on uo.id_user = u.id " +
            "where a.status = 1  and a.id_stock = uo.id_stock and a.type = 1 and a.status = uo.status and  u.id = ?1) where id = ?1", nativeQuery = true)
    int updateDollarBalance (User user);

    @Modifying
    @Query(value = "update users set dollar_balance = (select  u.dollar_balance - uo.remaining_value  * uo.price  "   + " FROM users_orders a, users_orders uo " +
            "inner join users u on uo.id_user = u.id " +
            "where a.status = 1  and a.id_stock = uo.id_stock and a.type = 1 and a.status = uo.status and  u.id = ?1) where id = ?1", nativeQuery = true)
    int updateDollarBalance2 (User user);

    // atauliza dinheiro do usuario quando comrpas

    @Query(value = "SELECT * from users_orders where status =1 and type = 0 ", nativeQuery = true)
    List<UserOrder> findByStatus();
    // seleciona compras abertas

    @Modifying
    @Query(value = "update users_stocks_balances set volume = (select a.volume - a.remaining_value " +
            " AS ID FROM users_orders a, users_orders uo " +
            " inner join users u on uo.id_user = u.id " +
            " inner join users_stocks_balances usb on u.id = usb.id_user " +
            " WHERE a.type <> uo.type  and a.id_stock = uo.id_stock and a.id_order= ?1 ) where id_user = ?2 and id_stock = ?3", nativeQuery = true)
    int atualizarBalance(Long id_order, User id_user, Long id_stock);
    // calaculo do Stock balance quando realizada a compra

    @Query (value = " select * from " +
            "users_orders a, users_orders b where a.remaining_value > b.volume and a.type = 0 ", nativeQuery = true)
    List <UserOrder> fyndteste();

    @Modifying
    @Query(value = " update users_orders  set remaining_value = (SELECT MAX(a.remaining_value) - MIN(b.volume)AS ID FROM users_orders a, users_orders b  WHERE a.type <> b.type  and a.id_stock = b.id_stock and a.id_order= ?1) where id_order= ?1 and type = 0 ",nativeQuery = true)
    int atualizarvalue(UserOrder id_order);

    @Query(value = "select * from " +
            "           users_orders a, users_orders b where  a.remaining_value < b.volume and a.type = 0 and a.status = 1", nativeQuery = true)
    List<UserOrder>findtTesteN();

    @Modifying
    @Query(value = " update users_orders  set remaining_value = (select (MAX(a.remaining_value ) - MIN(b.remaining_value)) from " +
            "  users_orders a, users_orders b where  a.type =0 ) where id_order=?1 and type = 0",nativeQuery = true )
    int AtuaalizarValue(UserOrder id_order);



}