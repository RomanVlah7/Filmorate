package com.romanv.filmorate.storage;

import com.romanv.filmorate.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class InMemoryUserStorage implements UserStorage {

    private final static ArrayList<User> users = new ArrayList<>();

    public static User getById(long userID) {
        for (User user : users) {
            if (user.getId() == userID) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addNewUserToUserStorage(User user) {
        users.add(user);
    }

    @Override
    public void deleteUserFromUserStorage(Long userID) {
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getId(), userID)) {
                users.remove(i);
            }
        }
    }

    @Override
    @ResponseBody
    public List<User> listUsersFromUserStorage() {
        return users;
    }

    @Override
    public boolean containsUserWithID(Long userID) {
        boolean result = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userID)) {
                result = true;
            }
        }
        return result;
    }
}
