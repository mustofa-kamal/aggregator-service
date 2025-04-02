package com.example.aggregator.controller;


import com.example.aggregator.dto.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/product")
    public Product getProduct() {
        Product p = new Product();
        p.setId(1L);
        p.setName("iPhone 16");
        return p;
    }
}
