package com.okta.springbootspa.restController;

import com.okta.springbootspa.dto.UserOrderDto;
import com.okta.springbootspa.dto.UserStockDto;
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
    public UserOrder match(@RequestBody UserOrderDto dto, UserStockDto stdo)  {
        Long id_stockS = stdo.getId_stock();
//
//        System.out.println(id_userS + "Alou");
        System.out.println(id_stockS);
        if(dto.getType() == 0){
            List<UserOrder> userOrders =vendaRepository.findMatches(dto.getId_stock());
            List<UserOrder> userBuyPO= compraRepository.fyndBuyPO();
            List<UserOrder> userBuyNE= compraRepository.findBuyNE();
            List<UserOrder> userSalePO = vendaRepository.findSalePO();
            List<UserOrder> userSaleNE = vendaRepository.findSaleNE();
            if (userOrders.isEmpty()){
                System.out.println(dto.getStatus());
                if(!userBuyNE.isEmpty()) {
                    System.out.println("compra negativa");
                    for (UserOrder cont:userBuyNE)  {
                        System.out.println(dto.getId_order());
                        compraRepository.updateDollarBalanceNE(cont, cont.getId_user());
                        compraRepository.RemainingNE(cont);
                        compraRepository.atualizarBalanceNE(cont.getId_order(),cont.getId_user(), cont.getId_stock());
                    }
                    vendaRepository.updateStatus2();
                }
                    if(!userSalePO.isEmpty() ){
                    System.out.println("venda positiva");
                    for (UserOrder cont: userSalePO) {
                        vendaRepository.updateDollarBalancePO(cont.getId_user());
                        vendaRepository.updateRemainingPO(cont.getId_stock(),cont);
                        vendaRepository.atualizarBalancePO(cont.getId_user(), cont.getId_stock());
                    }
                }
                if(!userBuyPO.isEmpty()){
                    System.out.println("compra positiva");
                    for ( UserOrder cont: userBuyPO ) {
                        compraRepository.updateDollarBalancePO(cont.getId_user(), cont);
                        compraRepository.RemainigPO(cont, cont.getId_user());
                        compraRepository.atualizarBalancePO(cont.getId_order(), cont.getId_user(), cont.getId_stock());
                        }
                    }
                }
                if (!userSaleNE.isEmpty()){
                    System.out.println("venda negativa");
                    for (UserOrder cont: userSaleNE) {
                        vendaRepository.updateBallanceNE(cont.getId_user(), cont.getId_stock());
                        vendaRepository.updateDollarBalanceNE(cont, cont.getId_user());
                        vendaRepository.updateRemainingNE(cont);
                    }
                }
                vendaRepository.updateStatus2();
            }

        return null;
    }
}

