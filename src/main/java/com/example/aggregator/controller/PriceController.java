package com.example.aggregator.controller;


import com.example.aggregator.dto.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
    @GetMapping("/price")
    public Price getPrice() {
        Price p = new Price();
        p.setId(1L);
        p.setAmount(1299.99);
        return p;
    }
}
