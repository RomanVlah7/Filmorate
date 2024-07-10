package com.romanv.filmorate.dao.interfaces;

import com.romanv.filmorate.model.Film;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FilmDaoInterface {
    List<Map<String,Object>> addFilmToDB(String title, String description);

    void deleteFilmFromDB(Long filmID);

    void likeFilmFromDB(Long filmID);

    void removeLikeForFilmFromDB(Long filmID);

    List<Film> listFilmsFromDB();

    List<Map<String,Object>> listTopTenFromDB();

    boolean contains(Long filmID);

    ResponseEntity<Map<String, String>> editFilmDataInDB(Film film);
}
