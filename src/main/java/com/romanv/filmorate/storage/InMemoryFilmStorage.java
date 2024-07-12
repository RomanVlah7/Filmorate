package com.romanv.filmorate.storage;

import com.romanv.filmorate.exceptions.handler.ExceptionHandlers;
import com.romanv.filmorate.exceptions.handler.exceptions.FilmAlreadyExistsException;
import com.romanv.filmorate.exceptions.handler.exceptions.FilmNotFoundException;
import com.romanv.filmorate.model.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class InMemoryFilmStorage implements FilmStorage {
    private static TreeMap<Long, Film> films = new TreeMap<>();

    public static Film getById(Long filmID) {
        return films.get(filmID);
    }

    public ResponseEntity<Map<String, String>> addFilmToStorage(Film film) {
        if (!films.containsKey(film.getId())) {
            films.put(film.getId(), film);
            return null;
        } else {
            return ExceptionHandlers.filmAlreadyExists(new FilmAlreadyExistsException());
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteFilmFromStorage(Long filmID) {
        if (!films.containsKey(filmID)) {
            return ExceptionHandlers.filmNotFound(new FilmNotFoundException());
        } else {
            films.remove(filmID);
            return null;
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> likeFilmFromStorage(Long filmID, Long userIdWhoWantsToLikeFilm) {
        if (films.containsKey(filmID)) {
            films.get(filmID).likeThisFilm(userIdWhoWantsToLikeFilm);
            return null;
        } else {
            return ExceptionHandlers.filmNotFound(new FilmNotFoundException());
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> removeLikeForFilmFromStorage(Long filmID) {
        return null;
    }

    @Override
    public List<Film> listFilmsFromStorage() {
        return films.values().stream().toList();
    }

    @Override
    public ResponseEntity<Object> listTopTenFromStorage() {
        return null;
    }

    @Override
    public boolean contains(Long filmID) {
        return films.containsKey(filmID);
    }

    @Override
    public ResponseEntity<Map<String, String>> editFilmDataInStorage(Film film) {
        if (!films.containsKey(film.getId())) {
            return ExceptionHandlers.filmNotFound(new FilmNotFoundException());
        } else {
            films.remove(film.getId());
            films.put(film.getId(), film);
            return null;
        }
    }
}
