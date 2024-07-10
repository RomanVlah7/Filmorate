package com.romanv.filmorate.dao;

import com.romanv.filmorate.dao.interfaces.UserDaoInterface;
import com.romanv.filmorate.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDao implements UserDaoInterface {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void addNewUserToUserStorage(String name, String login) {
        jdbcTemplate.execute("INSERT INTO all_users(username, login) VALUES ('" + name + "', '" + login + "')");
    }

    @Override
    public void deleteUserFromUserStorage(Long userID) {
        jdbcTemplate.execute("DELETE FROM all_users WHERE user_id = "+ userID +")");
    }

    @Override
    public List<Map<String,Object>> listUsersFromUserStorage() {
        return jdbcTemplate.queryForList("SELECT name, login FROM all_users");
    }
}
