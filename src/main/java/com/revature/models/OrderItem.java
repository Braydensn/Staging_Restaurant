package com.revature.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    Order order;

    @ManyToOne
    @Column(name = "menu_item")
    MenuItem menuItem;
}
