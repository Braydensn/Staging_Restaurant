package com.revature.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "street_address")
    String streetAddress;
    String city;
    String zip;
    String state;


}
