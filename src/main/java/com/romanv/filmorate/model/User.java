package com.romanv.filmorate.model;

import com.romanv.filmorate.managers.UserIDManager;
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
    private TreeMap<String, Long> friends;
    private TreeSet<Long> likedFilms;

    public User(Long id, String email, String login, String name, Instant birthDate, TreeMap<String, Long> friends, TreeSet<Long> likedFilms) {
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
        friends.put(userToAdd.getName(), userToAdd.getId());
    }

    public void addToLikedFilms(Long filmIDtoLike) {
        if (likedFilms.contains(filmIDtoLike)) {
            //nothing
        } else {
            likedFilms.add(filmIDtoLike);
        }
    }

    public void removeFromLikedList(long filmID) {
        likedFilms.remove(filmID);
    }

}
