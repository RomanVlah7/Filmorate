package com.romanv.filmorate.storage;

import com.romanv.filmorate.model.User;

import java.util.List;

public interface UserStorage {
    void addNewUserToUserStorage(User user);

    void deleteUserFromUserStorage(Long userID);

    List<User> listUsersFromUserStorage();

    boolean containsUserWithID(Long userID);
}
