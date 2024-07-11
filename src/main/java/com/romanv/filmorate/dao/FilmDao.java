package com.romanv.filmorate.dao;

import com.romanv.filmorate.dao.interfaces.FilmDaoInterface;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class FilmDao implements FilmDaoInterface {

    JdbcTemplate jdbcTemplate;

    @Override
    public void addFilmToDB(String title, String description) {
        jdbcTemplate.update("INSERT INTO films(title, description) VALUES ?, ?", title, description);
    }

    @Override
    public void deleteFilmFromDB(Long filmID) {
        jdbcTemplate.update("DELETE FROM films WHERE film_id = ?", filmID);
    }

    @Override
    public void likeFilmFromDB(Long filmID) {
        jdbcTemplate.update("UPDATE films SET likes = likes + 1 WHERE film_id = ?", filmID);
    }

    @Override
    public void removeLikeForFilmFromDB(Long filmID) {
        jdbcTemplate.update("UPDATE films SET likes = likes - 1 WHERE film_id = ?", filmID);
    }

    @Override
    public List<Map<String,Object>> listFilmsFromDB() {
        return jdbcTemplate.queryForList("SELECT title, description FROM films");
    }

    @Override
    public List<Map<String, Object>> listTopTenFromDB() {
        return jdbcTemplate.queryForList("SELECT title, description FROM films ORDER BY likes");
    }

    @Override
    public void editFilmDataInDB(String filmID, String newTitle, String newDescription) {
        jdbcTemplate.update("UPDATE films SET title = ? description = ? WHERE film_id = ?", newTitle, newDescription,
                filmID);
    }
}
