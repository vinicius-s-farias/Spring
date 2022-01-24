package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserOrder;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {


}





