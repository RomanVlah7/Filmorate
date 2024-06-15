package com.romanv.filmorate.services;

import com.romanv.filmorate.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserServiceInterface {
    ResponseEntity<Map<String, String>> addUser(User user);

    List<User> listUsers();

    ResponseEntity<Map<String, String>> mutualAdditionToFriends(User user1, User user2);

    ResponseEntity<Map<String, String>> deleteUser(Long userID);

    public ResponseEntity<Map<String, String>> editUserData(User editedUser);
}
