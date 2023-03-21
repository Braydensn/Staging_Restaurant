package com.revature.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    String email;
    String password;

    @Column(name = "first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @OneToOne
    Address address;

}
