package com.romanv.filmorate.dao;

import com.romanv.filmorate.dao.interfaces.FilmDaoInterface;
import com.romanv.filmorate.model.Film;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class FilmDao implements FilmDaoInterface {

    @Override
    public List<Map<String, Object>> addFilmToDB(String title, String description) {
        return null;
    }

    @Override
    public void deleteFilmFromDB(Long filmID) {

    }

    @Override
    public void likeFilmFromDB(Long filmID) {

    }

    @Override
    public void removeLikeForFilmFromDB(Long filmID) {

    }

    @Override
    public List<Film> listFilmsFromDB() {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> listTopTenFromDB() {
        return List.of();
    }

    @Override
    public boolean contains(Long filmID) {
        return false;
    }

    @Override
    public ResponseEntity<Map<String, String>> editFilmDataInDB(Film film) {
        return null;
    }
}
