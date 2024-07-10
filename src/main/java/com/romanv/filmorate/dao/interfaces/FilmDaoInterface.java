package com.romanv.filmorate.dao.interfaces;

import com.romanv.filmorate.model.Film;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FilmDaoInterface {
    List<Map<String,Object>> addFilmToStorage(Film film);

    void deleteFilmFromStorage(Long filmID);

    void likeFilmFromStorage(Long filmID, Long userIDwhoWantsToLike);

    void removeLikeForFilmFromStorage(Long filmID);

    List<Film> listFilmsFromStorage();

    List<Map<String,Object>> listTopTenFromStorage();

    boolean contains(Long filmID);

    ResponseEntity<Map<String, String>> editFilmDataInStorage(Film film);
}
