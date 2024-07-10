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
    private String userName;
    @NotBlank
    private String description;
    @Past
    private Instant releaseDate;
    @JsonDeserialize(using = DurationDesializer.class)
    private int durationOfFilm;
    private int peopleWhoLiked;
    private String filmGenre;
    private String filmMPARate;

    public Film(long id, String userName, String description, Instant releaseDate, int durationOfFilm, int peopleWhoLiked, String filmGenre, String filmMPARate) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.releaseDate = releaseDate;
        this.durationOfFilm = durationOfFilm;
        this.peopleWhoLiked = peopleWhoLiked;
        this.filmGenre = filmGenre;
        this.filmMPARate = filmMPARate;
    }

    public void likeThisFilm(long userIDwhoWantsToLike){
        //todo
    }

    private enum FilmGenre {
        COMEDY,
        DRAMA,
        CARTOON,
        THRILLER,
        DOCUMENTARY,
        ACTION_MOVIE
    }

    private enum FilmMPARate{
        G,
        PG_13,
        PG,
        R,
        NC_17
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
