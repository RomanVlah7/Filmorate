package com.romanv.filmorate.dao.interfaces;

import com.romanv.filmorate.model.User;

import java.util.List;
import java.util.Map;

public interface UserDaoInterface {

    void addNewUserToUserStorage(String name, String login);

    void deleteUserFromUserStorage(Long userID);

    List<Map<String,Object>> listUsersFromUserStorage();
}
