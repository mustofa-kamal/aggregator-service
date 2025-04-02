package com.example.aggregator.controller;


import com.example.aggregator.dto.ProductDetail;
import com.example.aggregator.service.AggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


@RestController
@RequiredArgsConstructor
public class AggregatorController {

    private final AggregatorService aggregatorService;

    @GetMapping("/product-details")
    public CompletableFuture<ProductDetail> getProductDetail() {

        return aggregatorService.fetchProductDetail();
    }
}
