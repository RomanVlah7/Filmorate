package com.romanv.filmorate.services;

import com.romanv.filmorate.model.Film;
import com.romanv.filmorate.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FilmIServiceInterface {
    ResponseEntity<Map<String, String>> addFilm(Film film);

    ResponseEntity<Map<String, String>> deleteFilm(Long filmID);

    public ResponseEntity<Map<String, String>> likeFilm(Long userIDWhoLikedFilm, Long filmIDtoLike);

    ResponseEntity<Map<String, String>> removeLike(User userWhoWantToRemoveLike, Long filmIDtoRemoveLike);

    List<Film> listFilms();

    List<Film> listTopTen();

    ResponseEntity<Map<String, String>> updateFilmData(Film film);

    boolean contains(Long filmID);
}
