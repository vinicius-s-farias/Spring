package com.okta.springbootspa.restController;

import com.okta.springbootspa.dto.UserOrderDto;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.CompraRepository;
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
     @Autowired
    private CompraRepository compraRepository;

 @PostMapping("/venda")
    public UserOrder vender(@RequestBody UserOrderDto dto) throws SQLException {
        if(dto.getType() != 2){
            List<UserOrder> userOrders =vendaRepository.findByTypeStock2(dto.getId_stock());
            List<UserOrder> userStatus = vendaRepository.findByStatus2();
            List<UserOrder> userteste= compraRepository.fyndteste();
            List<UserOrder> compratesteN= compraRepository.findtTesteN();
            List<UserOrder> vendatesteN= vendaRepository.findtTesteN();
            if (userOrders != null){
                List<UserOrder> userFind = vendaRepository.findByCalculo2();
                System.out.println(dto.getStatus());
                if(!userteste.isEmpty()){
                    System.out.println("Sou da compra Positivo");
                    for ( UserOrder cont: userteste ) {
                        compraRepository.updateDollarBalance(cont.getId_user());
                        compraRepository.AtuaalizarValue(cont);
                        compraRepository.updateStatus(cont);
                        compraRepository.atualizarBalance(cont.getId_order(), cont.getId_user(), cont.getId_stock());
                    }
                }
                if (!userFind.isEmpty()){
                    for (UserOrder cont: userFind) {
                        System.out.println("Sou da venda negativo ");
                        vendaRepository.updateDollarBalance1(cont,cont.getId_user());
                        vendaRepository.updateRemainingValue2(cont);
                        vendaRepository.updateStatus2(cont);
                        vendaRepository.atualizarBalance2(cont.getId_user(), cont.getId_stock());
                    }
                }
//                if(!compratesteN.isEmpty()) {
//                    System.out.println("Sou da Compra Negativo");
//                    for (UserOrder cont: compratesteN)  {
//                        compraRepository.updateDollarBalance2(cont.getId_user());
//                        compraRepository.AtuaalizarValue(cont);
//                        compraRepository.updateStatus(cont);
//                        compraRepository.atualizarBalance(cont.getId_order(),cont.getId_user(), cont.getId_stock());
//
//                    }
//                }
   //             if(!vendatesteN.isEmpty() ){
//                    System.out.println("Sou da venda Positivo ");
//                    for (UserOrder cont: vendatesteN) {
//                        vendaRepository.updateRemainingValue2(cont);
//                        vendaRepository.updateStatus(cont);
//                        vendaRepository.atualizarBalance2(cont.getId_user(), cont.getId_stock());
//                        vendaRepository.updateDollarBalance2(cont.getId_user());
//                        vendaRepository.updateStatus2(cont);
//                    }
//                }

            }
        }
        return null;
    }

}


