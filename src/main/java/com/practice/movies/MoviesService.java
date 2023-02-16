package com.practice.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired  // It will let the framework know that we want to instantiate the MovieRepository class here for us
    private MoviesRepository moviesRepository;
    public List<MoviesEntity> allMovies(){
        return moviesRepository.findAll();
     }

//     public Optional<MoviesEntity> moviesById(ObjectId id) {    //If the id passed does'nt exist the optional returns null otherwise the id's data is fetched
//         return moviesRepository.findById(id);
//     }

         public Optional<MoviesEntity> moviesByImdbId(String imdbId) {
             return moviesRepository.findMoviesByImdbId(imdbId);
     }
}
