/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.service.ReviewJpaService;

@RestController
public class ReviewController {

    @Autowired
    private ReviewJpaService reviewJpaService;

    @GetMapping("/products/reviews")
    public List<Review> getAllReview() {
        return reviewJpaService.getAllReview();
    }

    @PostMapping("/products/reviews")
    public Review addNewReview(@RequestBody Review review) {
        return reviewJpaService.addNewReview(review);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId) {
        return reviewJpaService.getReviewById(reviewId);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(
            @PathVariable int reviewId,
            @RequestBody Review review) {

        return reviewJpaService.updateReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable int reviewId) {
        reviewJpaService.deleteReview(reviewId);
    }

    @GetMapping("/reviews/{reviewId}/product")
    public Product getProductByReviewId(@PathVariable int reviewId) {
        return reviewJpaService.getProductByReviewId(reviewId);
    }
}