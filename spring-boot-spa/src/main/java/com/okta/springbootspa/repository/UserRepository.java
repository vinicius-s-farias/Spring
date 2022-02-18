package com.okta.springbootspa.repository;

import com.okta.springbootspa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value =  " select * from users s where username = ?1  " , nativeQuery = true)
//    List<User> FindUser(String username);

}
