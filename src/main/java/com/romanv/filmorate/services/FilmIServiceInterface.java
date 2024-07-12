package com.romanv.filmorate.services;

import java.util.List;
import java.util.Map;

public interface FilmIServiceInterface {
    void addFilm(String title, String description);

    List<Map<String, Object>> listFilms();

    void updateFilmData(Long filmID, String newTitle, String newDescription);

    void likeFilm(Long filmID);
}
