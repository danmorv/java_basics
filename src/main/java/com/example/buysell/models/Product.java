package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String descriptions;
    private int price;
    private String city;
    private String author;
}
