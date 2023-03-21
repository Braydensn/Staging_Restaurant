package com.revature.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    Customer customer;

    String status;
    Boolean delivery;
    @Column(name = "time_created")
    LocalDateTime timeCreated;
    @Column(name = "time_ready")
    LocalDateTime timeReady;

    @Column(name = "total_price")
    Double totalPrice;
}
