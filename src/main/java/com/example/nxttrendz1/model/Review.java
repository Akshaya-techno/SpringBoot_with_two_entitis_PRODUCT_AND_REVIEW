/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.nxttrendz1.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "reviewid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    @Column(name = "reviewcontent")
    private String reviewContent;
    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    public Review() {
    }

    public Review(int reviewId, String reviewContent, int rating) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.rating = rating;

    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

}

