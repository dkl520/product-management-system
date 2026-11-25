package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    @Id
    private  long id;
    private String name;
    private String description;
    private int stock;

}
