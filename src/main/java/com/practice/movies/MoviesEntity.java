package com.practice.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/* Document annotation serves only for specifying collection properties.
This annotation may however be important for some kind of annotation
based process to target which document are in use (maybe for indexing and so on) */
@Document(collection = "movies") //Inherited from db name "movies"
@Data // Comes from Lombok and take cares of getters setters and toString methods
@AllArgsConstructor // Annotation for creating a constructor that takes all these private fields as argument
@NoArgsConstructor //Takes no parameter

/* Note that all the private fields declared below matches the same as present in the mongo database */
public class MoviesEntity {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backDrops;

    //The List<Review> is an embedded relationship, all the reviews related to movies will be added in the
    // review list, this can be an example of one to many relationship as one movie can have multiple reviews
    @DocumentReference //This annotation tells the db to store only the ids of the review & the reviews will be in separate collections 
    private List<ReviewEntity> reviewIds;

}
