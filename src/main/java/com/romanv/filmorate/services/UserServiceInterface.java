package com.romanv.filmorate.services;

import com.romanv.filmorate.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserServiceInterface {
    void addUser(String name, String login);

    List<Map<String, Object>> listUsers();

    ResponseEntity<Map<String, String>> mutualAdditionToFriends(User user1, User user2);

    void deleteUser(Long userID);

    void editUserData(String userID, String name, String login);
}
