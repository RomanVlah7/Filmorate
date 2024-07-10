package com.romanv.filmorate.services;

import com.romanv.filmorate.model.Film;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FilmIServiceInterface {
    ResponseEntity<Map<String, String>> addFilm(Film film);

    List<Film> listFilms();

    ResponseEntity<Map<String, String>> updateFilmData(Film film);

    boolean contains(Long filmID);
}
