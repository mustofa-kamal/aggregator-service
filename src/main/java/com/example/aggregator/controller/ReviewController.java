package com.example.aggregator.controller;


import com.example.aggregator.dto.Review;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @GetMapping("/review")
    public Review getReview() {
        Review r = new Review();
        r.setId(1L);
        r.setReview("Excellent phone!");
        return r;
    }
}
