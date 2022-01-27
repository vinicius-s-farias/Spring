package com.okta.springbootspa.restController;

import com.okta.springbootspa.dto.UserOrderDto;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class VendaController {
     @Autowired
     private VendaRepository vendaRepository;

 @PostMapping("/venda")
    public UserOrder vender(@RequestBody UserOrderDto dto) throws SQLException {
        if(dto.getType() == 1){
            List<UserOrder> userOrders =vendaRepository.findByTypeStock2(dto.getId_stock());
            List<UserOrder> userStatus = vendaRepository.findByStatus2();
            if (userOrders != null){
                List<UserOrder> userFind = vendaRepository.findByCalculo2();
                System.out.println(dto.getStatus());
                if(!userFind.isEmpty() ){
                    System.out.println("cheguei");
                    for (UserOrder cont: userFind) {
                        vendaRepository.updateRemainingValue2(cont);
                        vendaRepository.updateStatus(cont);
                        vendaRepository.atualizarBalance2(cont.getId_user(), cont.getId_stock());
                    }
                }
                if (!userStatus.isEmpty()){
                    for (UserOrder cont: userStatus) {
                        System.out.println("novo");
                        vendaRepository.updateDollarBalance2(cont.getId_user());
                        vendaRepository.updateStatus2(cont);
                    }

                }

            }
        }
        return null;
    }

}


