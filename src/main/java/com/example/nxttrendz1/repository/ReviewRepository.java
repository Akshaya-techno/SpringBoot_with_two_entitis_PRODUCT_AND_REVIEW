/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.*;
import java.util.*;

public interface ReviewRepository {
    List<Review> getAllReview();

    Review addNewReview(Review review);

    Review getReviewById(int reviewId);

    Review updateReview(int reviewId, Review review);

    void deleteReview(int reviewId);

    Product getProductByReviewId(int reviewId);
}