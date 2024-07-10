package com.romanv.filmorate.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.util.TreeMap;
import java.util.TreeSet;

@Data
public class User implements Comparable<User> {
    private final Long id;
    @Email
    private String email;
    @NotBlank(message = "Email is NULL or incorrect")
    private String login;
    @NotBlank(message = "Name is NULL or incorrect")
    private String name;
    @Past
    private Instant birthDate;
    private int friends;
    private int likedFilms;

    public User(Long id, String email, String login, String name, Instant birthDate, int friends, int likedFilms) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = name;
        this.birthDate = birthDate;
        this.friends = friends;
        this.likedFilms = likedFilms;
    }

    @Override
    public int compareTo(User user) {
        int result;
        return result = user.getName().compareToIgnoreCase(this.getName());
    }

    public void addToFriendsList(User userToAdd) {
        //todo
    }

    public void addToLikedFilms(Long filmIDtoLike) {
        //todo
    }

    public void removeFromLikedList(long filmID) {
        likedFilms.remove(filmID);
    }

    private enum friendshipStatus{
        UNPROVED,
        PROVED
    }
}
