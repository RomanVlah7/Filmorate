package com.romanv.filmorate.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface UserDaoInterface {

    void addNewUserToUserDB(String name, String login);

    void deleteUserFromUserDB(Long userID);

    List<Map<String, Object>> listUsersFromUserDB();

    void editUserDataFromDB(String userID, String newName, String newLogin);
}
