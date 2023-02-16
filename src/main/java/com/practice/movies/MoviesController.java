package com.practice.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<MoviesEntity>> getAllMovies() {
        return new ResponseEntity<List<MoviesEntity>>(moviesService.allMovies(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<MoviesEntity>> getMoviesById(@PathVariable ObjectId id) {   //@Pathvariable lets the framework know that whatever data we are getting through the path variable we want to convert them into an objectId called id
//        return new ResponseEntity<Optional<MoviesEntity>>(moviesService.moviesById(id), HttpStatus.OK);
//    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<MoviesEntity>> getMoviesByImdbId(@PathVariable String imdbId) {   //@Pathvariable lets the framework know that whatever data we are getting through the path variable we want to convert them into an objectId called id
        return new ResponseEntity<Optional<MoviesEntity>>(moviesService.moviesByImdbId(imdbId), HttpStatus.OK);
    }
}
