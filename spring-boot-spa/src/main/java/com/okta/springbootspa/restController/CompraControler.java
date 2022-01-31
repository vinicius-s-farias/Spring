//package com.okta.springbootspa.restController;
//
//import com.okta.springbootspa.model.User;
//import com.okta.springbootspa.model.UserOrder;
//import com.okta.springbootspa.repository.CompraRepository;
//import com.okta.springbootspa.repository.UserOrderRepository;
//import com.okta.springbootspa.dto.UserOrderDto;
//import com.okta.springbootspa.repository.UserRepository;
//import jdk.swing.interop.SwingInterOpUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.SQLException;
//import java.util.List;
//
//
//@RestController
//public class CompraControler {
//    @Autowired
//    private CompraRepository compraRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/compra")
//    public UserOrder compra(@RequestBody UserOrderDto dto) throws SQLException {
//        if(dto.getType() == 1){
//            List<UserOrder> userOrders =compraRepository.findByTypeStock(dto.getId_stock());
//            List<UserOrder> userStatus = compraRepository.findByStatus();
//            List<UserOrder> userteste= compraRepository.fyndteste();
//            List<UserOrder> userteste1= compraRepository.findtTesteN();
//            if (userOrders != null){
//                List<UserOrder> userFind = compraRepository.findByCalculo();
//                System.out.println(dto.getStatus());
//                if(!userFind.isEmpty() ){
//                    System.out.println("cheguei");
//
//                    for (UserOrder cont: userFind) {
////                        compraRepository.updateRemainingValue(cont);
////                        compraRepository.atualizarBalance(cont.getId_user(), cont.getId_stock());
//                    }
//                }
////                if (!userStatus.isEmpty()){
////                    for (UserOrder cont: userStatus) {
////                        System.out.println("novo");
////                        compraRepository.updateDollarBalance(cont.getId_user());
//////                        compraRepository.updateStatus2(cont);
////                    }
////
////                }
//                if(!userteste.isEmpty()){
//                    System.out.println("Cheigueieie");
//                    for ( UserOrder cont: userteste ) {
//                        compraRepository.updateDollarBalance(cont.getId_user());
//                        compraRepository.AtuaalizarValueP(cont);
//                        compraRepository.updateStatus(cont);
//                        compraRepository.atualizarBalance(cont.getId_order(), cont.getId_user(), cont.getId_stock());
//                    }
//                }
//                if(!userteste1.isEmpty()) {
//                    System.out.println("alouuuuuuuu");
//                    for (UserOrder cont:userteste1)  {
//                        compraRepository.updateDollarBalance2(cont.getId_user());
//                        compraRepository.AtuaalizarValueN(cont);
//                        compraRepository.updateStatus(cont);
//                        compraRepository.atualizarBalance(cont.getId_order(),cont.getId_user(), cont.getId_stock());
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//
//}
//
//
//
//
//
