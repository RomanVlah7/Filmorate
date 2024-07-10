package com.romanv.filmorate.dao;

import com.romanv.filmorate.dao.interfaces.FilmDaoInterface;
import com.romanv.filmorate.model.Film;
import com.romanv.filmorate.services.FilmIServiceInterface;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class FilmDao implements FilmDaoInterface {

    @Override
    public List<Map<String, Object>> addFilmToStorage(Film film) {
        return List.of();
    }

    @Override
    public void deleteFilmFromStorage(Long filmID) {

    }

    @Override
    public void likeFilmFromStorage(Long filmID, Long userIDwhoWantsToLike) {

    }

    @Override
    public void removeLikeForFilmFromStorage(Long filmID) {

    }

    @Override
    public List<Film> listFilmsFromStorage() {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> listTopTenFromStorage() {
        return List.of();
    }

    @Override
    public boolean contains(Long filmID) {
        return false;
    }

    @Override
    public ResponseEntity<Map<String, String>> editFilmDataInStorage(Film film) {
        return null;
    }
}
