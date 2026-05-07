/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

import java.util.List;

@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public List<Review> getAllReview() {
        List<Review> review = reviewJpaRepository.findAll();
        return review;
    }

    @Override
    public Review addNewReview(Review review) {
        Product product = review.getProduct();
        int productId = product.getProductId();
        try{
            Product exist_Product = productJpaRepository.findById(productId).get();
            review.setProduct(exist_Product);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return reviewJpaRepository.save(review);
        
        
    }

    @Override
    public Review getReviewById(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review updateReview(int reviewId, Review review) {
        
        try {
            Review oldReview = reviewJpaRepository.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                oldReview.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                oldReview.setRating(review.getRating());
            }
            if(review.getProduct() != null){
                Product product = review.getProduct();
                int productId = product.getProductId();
                Product newProduct = productJpaRepository.findById(productId).get();
                oldReview.setProduct(newProduct);
            }

            reviewJpaRepository.save(oldReview);
            return oldReview;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            reviewJpaRepository.findById(reviewId).get();
            reviewJpaRepository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product getProductByReviewId(int reviewId) {
        try {
            Review review = reviewJpaRepository.findById(reviewId).get();
            return review.getProduct();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}