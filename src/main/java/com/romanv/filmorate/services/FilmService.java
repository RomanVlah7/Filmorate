package com.romanv.filmorate.services;

import com.romanv.filmorate.exceptions.handler.ExceptionHandlers;
import com.romanv.filmorate.exceptions.handler.exceptions.FilmAlreadyExistsException;
import com.romanv.filmorate.model.Film;
import com.romanv.filmorate.storage.InMemoryFilmStorage;
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
    public List<Film> listFilms() {
        return inMemoryFilmStorage.listFilmsFromStorage();
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