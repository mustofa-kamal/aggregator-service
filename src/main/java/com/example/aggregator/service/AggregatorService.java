package com.example.aggregator.service;





import com.example.aggregator.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class AggregatorService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    // The service itself runs on port 8084 as configured in application.yml.
    // Using the wrong port here results in connection failures when invoking
    // the internal endpoints. Update URLs to match the configured port.
    private final String productUrl = "http://localhost:8084/product";
    private final String reviewUrl = "http://localhost:8084/review";
    private final String priceUrl = "http://localhost:8084/price";




    public CompletableFuture<ProductDetail> fetchProductDetail() {
        CompletableFuture<Product> productFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject(productUrl, Product.class), executor);

        CompletableFuture<Review> reviewFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject(reviewUrl, Review.class), executor);

        CompletableFuture<Price> priceFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject(priceUrl, Price.class), executor);

        return CompletableFuture.allOf(productFuture, reviewFuture, priceFuture)
                .thenApply(v -> new ProductDetail(
                        productFuture.join(),
                        reviewFuture.join(),
                        priceFuture.join()
                ));
    }
}