package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<UserOrder, Long> {


}
