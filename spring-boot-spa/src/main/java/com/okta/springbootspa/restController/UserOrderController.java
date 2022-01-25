package com.okta.springbootspa.restController;

import java.sql.SQLException;
import java.util.List;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.UserOrderRepository;

import com.okta.springbootspa.repository.UserRepository;
import com.okta.springbootspa.dto.UserOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMapping;


@RestController

public class UserOrderController {

    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/usersorders")
    public List<UserOrder> listar() {
        return userOrderRepository.findAll();

    }

    @PostMapping("/order")
    public ResponseEntity<UserOrder> saveStockB(@RequestBody UserOrderDto uOrder) {
        User us = userRepository.findById(uOrder.getId_user()).orElseThrow();
        UserOrder uso = uOrder.transObj(us);
        return new ResponseEntity<>(userOrderRepository.save(uso), HttpStatus.CREATED);
//        return userStockRepository.save(ust);
    }

    @PostMapping("/compra")
    public UserOrder comprar(@RequestBody UserOrderDto dto) throws SQLException {

        if (dto.getType() == 1) {
            List<UserOrder> userOrders = userOrderRepository.findByTypeStock(dto.getId_stock());
            if (userOrders != null) {
                List<UserOrder> userFind = userOrderRepository.findByCalculo();
                List<UserOrder> userStatus = userOrderRepository.findByStatus();
                System.out.println(userFind);
                if (!userFind.isEmpty()) {
                    System.out.println("cheguei");
                    for (UserOrder cont : userFind) {
                        userOrderRepository.updateRemainingValue(cont);
                        userOrderRepository.updateStatus(cont);
                    }
                    if (!userStatus.isEmpty()){
                        System.out.println("Cheguei");
                        for (UserOrder cont: userStatus) {
                            System.out.println("novo");
                            userOrderRepository.updateDollarBalance(cont.getId_user());
                            userOrderRepository.updateStatus2(cont);
                        }
                    }

//                while(dto.getStatus() == 2 ){
//                    System.out.println("to aqui");
//                    for (UserOrder cont1: userStatus) {
//                        userOrderRepository.updateDollarBalance(cont1.getId_user());
//                    }

                    }

                }

            }
        return null;

        }


    }




