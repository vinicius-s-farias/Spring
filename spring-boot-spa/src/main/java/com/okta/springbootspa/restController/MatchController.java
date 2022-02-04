package com.okta.springbootspa.restController;

import com.okta.springbootspa.dto.UserOrderDto;
import com.okta.springbootspa.model.UserOrder;
import com.okta.springbootspa.repository.CompraRepository;
import com.okta.springbootspa.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
     @Autowired
     private VendaRepository vendaRepository;
     @Autowired
    private CompraRepository compraRepository;


    @PostMapping("/match")
    public UserOrder vender(@RequestBody UserOrderDto dto)  {

        if(dto.getType() == 0){
            List<UserOrder> userOrders =vendaRepository.findByTypeStock(dto.getId_stock());
            List<UserOrder> teste1 = vendaRepository.testando1();
            List<UserOrder> userteste= compraRepository.fyndteste();
            List<UserOrder> userteste1= compraRepository.findtTeste1();
            List<UserOrder> userFind = vendaRepository.findByCalculo();
            if (userOrders.isEmpty()){
                System.out.println(dto.getStatus());
                if(!userteste1.isEmpty()) {
                    System.out.println("compra negativa");
                    for (UserOrder cont:userteste1)  {
                        System.out.println(dto.getId_order());
                        compraRepository.updateDollarBalanceNE(cont, cont.getId_user());
                        compraRepository.RemainingNE(cont);
                        compraRepository.atualizarBalanceNE(cont.getId_order(),cont.getId_user(), cont.getId_stock());
                    }
                    vendaRepository.updateStatus2();
                }
                    if(!userFind.isEmpty() ){
                    System.out.println("venda positiva");
                    for (UserOrder cont: userFind) {
                        vendaRepository.updateDollarBalance(cont.getId_user());
                        vendaRepository.updateRemainingValue(cont.getId_stock(),cont);
                        vendaRepository.atualizarBalance(cont.getId_user(), cont.getId_stock());
                    }
                }
                if(!userteste.isEmpty()){
                    System.out.println("compra positiva");
                    for ( UserOrder cont: userteste ) {
                        compraRepository.updateDollarBalancePO(cont.getId_user(), cont);
                        compraRepository.RemainigPO(cont, cont.getId_user());
                        compraRepository.atualizarBalancePO(cont.getId_order(), cont.getId_user(), cont.getId_stock());
                    }
                    vendaRepository.updateStatus();
                }
                if (!teste1.isEmpty()){
                    System.out.println("venda negativa");
                    for (UserOrder cont: teste1) {
                        vendaRepository.RemainingNE(cont.getId_user(), cont.getId_stock());
                        vendaRepository.updateDollarBalanceNE(cont, cont.getId_user());
                        vendaRepository.updateRemainingValue2(cont);
                    }
                }
                vendaRepository.updateStatus2();
            }
        }
        return null;
    }
}

