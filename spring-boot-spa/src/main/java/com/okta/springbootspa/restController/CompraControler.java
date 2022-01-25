package com.okta.springbootspa.restController;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.CompraRepository;
import com.okta.springbootspa.repository.UserOrderRepository;
import com.okta.springbootspa.dto.UserOrderDto;
import com.okta.springbootspa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public class CompraControler {
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/compra")
//    public UserOrder comprar(@RequestBody UserOrderDto dto) throws SQLException {
//
//        if(dto.getType() == 0){
//            List<UserOrder> userOrders = compraRepository.findByTypeStock(dto.getId_stock());
//
//            if (userOrders != null){
//                List<UserOrder> userFind = compraRepository.findByCalculo();
//                List<UserOrder> userStatus = compraRepository.findByStatus();
//                System.out.println(userFind);
//                if(userFind != null){
//                    System.out.println("cheguei");
//
//                    for (UserOrder cont: userFind) {
//                        compraRepository.updateRemainingValue(cont);
//                        System.out.println(cont);
//                        compraRepository.updateStatus(cont);
//                        System.out.println(dto.getId_user());
//
//                    }
//                    if (userStatus != null){
//                        for (UserOrder cont: userStatus) {
//                            compraRepository.updateDollarBalance(cont);
//
//                        }
//                    }
//
//                }
//            }
//        }
//        return null;
//    }
//if(dtousuario.dollarbalance >= dto.getPrice * dto.getVolume())
}


