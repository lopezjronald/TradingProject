package com.ronaldlopez.trading.controller;

import com.ronaldlopez.trading.dao.UserRepository;
import com.ronaldlopez.trading.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Aggregate root

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable Integer id) {
         return userRepository.findById(id)
                 .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    return userRepository.save(newUser);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}



















