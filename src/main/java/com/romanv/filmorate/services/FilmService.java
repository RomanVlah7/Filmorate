package com.romanv.filmorate.services;

import com.romanv.filmorate.exceptions.handler.ExceptionHandlers;
import com.romanv.filmorate.exceptions.handler.exceptions.FilmAlreadyExistsException;
import com.romanv.filmorate.exceptions.handler.exceptions.FilmNotFoundException;
import com.romanv.filmorate.model.Film;
import com.romanv.filmorate.model.User;
import com.romanv.filmorate.storage.InMemoryFilmStorage;
import com.romanv.filmorate.storage.InMemoryUserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class FilmService implements FilmIServiceInterface {
    private InMemoryFilmStorage inMemoryFilmStorage = new InMemoryFilmStorage();

    @Override
    public ResponseEntity<Map<String, String>> addFilm(Film film) {
        if (inMemoryFilmStorage.contains(film.getId())) {
            return ExceptionHandlers.filmAlreadyExists(new FilmAlreadyExistsException());
        } else {
            inMemoryFilmStorage.addFilmToStorage(film);
            return null;
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteFilm(Long filmID) {
        if (inMemoryFilmStorage.contains(filmID)) {
            inMemoryFilmStorage.deleteFilmFromStorage(filmID);
            return null;
        } else {
            return ExceptionHandlers.filmNotFound(new FilmNotFoundException());
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> likeFilm(Long userIDWhoLikedFilm, Long filmIDtoLike) {
        if (inMemoryFilmStorage.contains(filmIDtoLike)) {
            inMemoryFilmStorage.likeFilmFromStorage(filmIDtoLike, userIDWhoLikedFilm);
            InMemoryUserStorage.getById(userIDWhoLikedFilm).addToLikedFilms(filmIDtoLike);
            return null;
        } else {
            return ExceptionHandlers.filmNotFound(new FilmNotFoundException());
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> removeLike(User userWhoWantToRemoveLike, Long filmIDtoRemoveLike) {
        if (inMemoryFilmStorage.contains(filmIDtoRemoveLike)) {
            inMemoryFilmStorage.removeLikeForFilmFromStorage(filmIDtoRemoveLike);
            userWhoWantToRemoveLike.removeFromLikedList(filmIDtoRemoveLike);
            return null;
        } else {
            return ExceptionHandlers.filmNotFound(new FilmNotFoundException());
        }
    }

    @Override
    public List<Film> listFilms() {
        return inMemoryFilmStorage.listFilmsFromStorage();
    }

    @Override
    public List<Film> listTopTen() {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> updateFilmData(Film film) {
        return inMemoryFilmStorage.editFilmDataInStorage(film);
    }

    @Override
    public boolean contains(Long filmID) {
        return inMemoryFilmStorage.contains(filmID);
    }
}