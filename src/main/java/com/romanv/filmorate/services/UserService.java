package com.romanv.filmorate.services;

import com.romanv.filmorate.dao.UserDao;
import com.romanv.filmorate.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j

public class UserService implements UserServiceInterface {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(String name, String login) {
        userDao.addNewUserToUserDB(name, login);
    }

    @Override
    public List<Map<String, Object>> listUsers() {
        return userDao.listUsersFromUserDB();
    }

    @Override
    public ResponseEntity<Map<String, String>> mutualAdditionToFriends(User user1, User user2) {
        //todo
        return null;
    }

    @Override
    public void deleteUser(Long userID) {
        userDao.deleteUserFromUserDB(userID);
    }

    @Override
    public void editUserData(String userID, String name, String login) {
        userDao.editUserDataFromDB(userID, name, login);
    }
}
