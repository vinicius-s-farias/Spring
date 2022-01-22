package com.okta.springbootspa.restController;

import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.UserOrderRepository;
import com.okta.springbootspa.dto.UserOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public class CompraControler {
    @Autowired
    private UserOrderRepository userOrderRepository;

    @PostMapping("/compra")
    public UserOrder comprar(@RequestBody UserOrderDto dto) throws SQLException {
        if(dto.getType() == 0){
            List<UserOrder> userOrders =userOrderRepository.findByTypeStock(dto.getId_stock());

            if (userOrders != null){
                for (UserOrder cont: userOrders) {
                    userOrderRepository.updateStatus(cont);
                }
            }
        }
        return null;
    }

}
