package com.romanv.filmorate.model;

import lombok.*;
import org.springframework.lang.NonNull;

import java.time.Duration;
import java.time.Instant;
@Data
public class Film {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Instant releaseDate;
    @NonNull
    private Duration durationOfFilm;
}
