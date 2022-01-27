package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.User;
import com.okta.springbootspa.model.UserOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


    @Repository

    public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {



    }







