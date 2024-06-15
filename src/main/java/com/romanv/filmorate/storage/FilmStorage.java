package com.romanv.filmorate.storage;

import com.romanv.filmorate.model.Film;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FilmStorage {
    ResponseEntity<Map<String, String>> addFilmToStorage(Film film);

    ResponseEntity<Map<String, String>> deleteFilmFromStorage(Long filmID);

    ResponseEntity<Map<String, String>> likeFilmFromStorage(Long filmID, Long userIDwhoWantsToLike);

    ResponseEntity<Map<String, String>> removeLikeForFilmFromStorage(Long filmID);

    List<Film> listFilmsFromStorage();

    ResponseEntity<Map<String, String>> listTopTenFromStorage();

    boolean contains(Long filmID);

    ResponseEntity<Map<String, String>> editFilmDataInStorage(Film film);

}
