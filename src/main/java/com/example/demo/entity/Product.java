package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    private  long id;
    private String name;
    private String description;
    private int stock;


}
