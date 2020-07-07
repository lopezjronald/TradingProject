package com.ronaldlopez.trading.dao;

import com.ronaldlopez.trading.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findById(@RequestParam("id") Integer id, Pageable pageable);

}
