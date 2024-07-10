package com.romanv.filmorate.services;

import com.romanv.filmorate.exceptions.handler.ExceptionHandlers;
import com.romanv.filmorate.exceptions.handler.exceptions.UserAlreadyExistsException;
import com.romanv.filmorate.exceptions.handler.exceptions.UserNotFoundException;
import com.romanv.filmorate.model.User;
import com.romanv.filmorate.storage.InMemoryUserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j

public class UserService implements UserServiceInterface {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private final ExceptionHandlers exceptionHandler = new ExceptionHandlers();


    @Override
    public ResponseEntity<Map<String, String>> addUser(User user) {
        if (inMemoryUserStorage.containsUserWithID(user.getId())) {
            return ExceptionHandlers.userAlreadyExists(new UserAlreadyExistsException());
        }else {
            inMemoryUserStorage.addNewUserToUserStorage(user);
            return null;
        }
    }

    @Override
    public List<User> listUsers() {
        return inMemoryUserStorage.listUsersFromUserStorage();
    }

    @Override
    public ResponseEntity<Map<String, String>> mutualAdditionToFriends(User user1, User user2) {
        if (!inMemoryUserStorage.containsUserWithID(user1.getId()) || !inMemoryUserStorage.containsUserWithID(user2.getId())) {
            return ExceptionHandlers.userNotFound(new UserNotFoundException());
        } else {
            user1.addToFriendsList(user2);
            user2.addToFriendsList(user1);
            return null;
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteUser(Long userID) {
        if (inMemoryUserStorage.containsUserWithID(userID)) {
            inMemoryUserStorage.deleteUserFromUserStorage(userID);
            return null;
        } else {
            return ExceptionHandlers.userNotFound(new UserNotFoundException());
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> editUserData(User editedUser) {
        Long userID = editedUser.getId();
        if(inMemoryUserStorage.containsUserWithID(editedUser.getId())){
            inMemoryUserStorage.deleteUserFromUserStorage(userID);
            inMemoryUserStorage.addNewUserToUserStorage(editedUser);
            return null;
        } else {
            return ExceptionHandlers.userNotFound(new UserNotFoundException());
        }
    }
}
