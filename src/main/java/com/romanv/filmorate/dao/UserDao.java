package com.romanv.filmorate.dao;

import com.romanv.filmorate.dao.interfaces.UserDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDao implements UserDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addNewUserToUserDB(String name, String login) {
        jdbcTemplate.update("INSERT INTO all_users(username, login) VALUES (?,?)", name, login);
    }

    @Override
    public void deleteUserFromUserDB(Long userID) {
        jdbcTemplate.update("DELETE FROM all_users WHERE user_id = ?", userID);
    }

    @Override
    public List<Map<String, Object>> listUsersFromUserDB() {
        return jdbcTemplate.queryForList("SELECT name, login FROM all_users");
    }

    @Override
    public void editUserDataFromDB(String userID, String name, String login) {
        jdbcTemplate.update("UPDATE all_users SET name = ? login =  ? WHERE userID = ?", name, login, userID);
    }
}