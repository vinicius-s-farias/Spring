package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

}
