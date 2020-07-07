package com.ronaldlopez.trading.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Trade> trades;

    User() {
    }

    User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
