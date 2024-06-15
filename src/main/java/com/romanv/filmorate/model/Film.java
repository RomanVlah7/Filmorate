package com.romanv.filmorate.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.romanv.filmorate.deserializers.DurationDesializer;
import com.romanv.filmorate.storage.InMemoryUserStorage;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.Duration;
import java.time.Instant;
import java.util.TreeMap;

@Data
public class Film {

    private final long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Past
    private Instant releaseDate;
    @JsonDeserialize(using = DurationDesializer.class)
    private Duration durationOfFilm;
    private TreeMap<Long, User> peopleWhoLiked = new TreeMap<>();
    private int numberOfLikes = 0;

    public Film(long id, String name, String description, Instant releaseDate, Duration durationOfFilm, TreeMap<Long, User> peopleWhoLiked, int numberOfLikes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.durationOfFilm = durationOfFilm;
        this.peopleWhoLiked = peopleWhoLiked;
        this.numberOfLikes = numberOfLikes;
    }

    public void likeThisFilm(long userIDwhoWantsToLike){
        if(!peopleWhoLiked.containsKey(userIDwhoWantsToLike)){
            peopleWhoLiked.put(userIDwhoWantsToLike, InMemoryUserStorage.getById(userIDwhoWantsToLike));
            ++numberOfLikes;
        }
    }
}

/*
{
"id": "1000",
"name": "Titanic",
"description": "description",
"releaseDate": "946413868",
"durationOfFilm": "7200",
"peopleWhoLiked": "null",
"numberOfLikes": "0"
}*/
