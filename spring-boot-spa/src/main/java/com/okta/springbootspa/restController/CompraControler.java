package com.okta.springbootspa.restController;

import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.CompraRepository;
import com.okta.springbootspa.repository.UserOrderRepository;
import com.okta.springbootspa.dto.UserOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public class CompraControler {
    @Autowired
    private CompraRepository compraRepository;

    @PostMapping("/compra")
    public UserOrder comprar(@RequestBody UserOrderDto userOrderDto) throws SQLException {
        if(userOrderDto.getType() == 0){
            List<UserOrder> userOrders = compraRepository.findByTypeStock(userOrderDto.getId_stock());
            if (userOrders != null){
                List<UserOrder> userFind = compraRepository.findByCalculo();
                System.out.println(userFind);
                if(userFind != null){
                    for (UserOrder cont: userFind) {
                        compraRepository.updateRemainingValue(cont);
                        compraRepository.updateStatus(cont);
                    }
                }
            }
        }
        return null;
    }

}
