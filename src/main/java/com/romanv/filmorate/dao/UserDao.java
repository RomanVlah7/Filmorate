package com.romanv.filmorate.dao;

import com.romanv.filmorate.dao.interfaces.UserDaoInterface;
import com.romanv.filmorate.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDao implements UserDaoInterface {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void addNewUserToUserDB(String name, String login) {
        jdbcTemplate.update("INSERT INTO all_users(username, login) VALUES (?,?,)", name, login);
    }

    @Override
    public void deleteUserFromUserDB(Long userID) {
        jdbcTemplate.update("DELETE FROM all_users WHERE user_id = ?", userID);
    }

    @Override
    public List<Map<String,Object>> listUsersFromUserDB() {
        return jdbcTemplate.queryForList("SELECT name, login FROM all_users");
    }
}