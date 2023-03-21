package com.revature.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String description;
    String category;
    @Column(name = "image_url")
    String imageUrl;
    Double price;

}
