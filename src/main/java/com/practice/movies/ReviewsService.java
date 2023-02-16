package com.practice.movies;

import org.springframework.stereotype.Service;

@Service
public class ReviewsService {

    // Here we first look for the movie with the user input imdbId & then we create a new review and associate it with the found movie
    public ReviewEntity createReview(String reviewBody, String imdbId){
        ReviewEntity review = new ReviewEntity();
    }
}
