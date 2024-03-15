package com.romanv.filmorate.model;

import lombok.*;
import org.springframework.lang.NonNull;

import java.time.Instant;

@Data
public class User {
    @NonNull
    private int id;
    @NonNull
    private String email;
    @NonNull
    private String login;
    @NonNull
    private String name;
    @NonNull
    private Instant birthDate;
}
