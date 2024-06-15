package com.romanv.filmorate.controllers;

import com.romanv.filmorate.exceptions.handler.ExceptionHandlers;
import com.romanv.filmorate.exceptions.handler.exceptions.FilmAlreadyExistsException;
import com.romanv.filmorate.model.Film;
import com.romanv.filmorate.model.User;
import com.romanv.filmorate.services.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/film")
@Slf4j
public class FilmController {

    private FilmService filmService = new FilmService();

    //----------------Post Mapping-----------------------------------------------------------------------

    @PostMapping("/addFilm")
    public ResponseEntity<Map<String, String>> addFilm(@RequestBody Film film) {
        if (filmService.contains(film.getId())) {
            return ExceptionHandlers.filmAlreadyExists(new FilmAlreadyExistsException());
        } else {
            filmService.addFilm(film);
            return null;
        }
    }

    //--------------------Patch Mapping------------------------------------------------------------------------

    @PatchMapping("/editFilm")
    public void updateFilmData(@RequestBody Film film) {
        filmService.updateFilmData(film);
    }

    @PatchMapping("/likeFilm")
    public ResponseEntity<Map<String, String>> likeTheFilm(@RequestHeader Long userIDWhoLikedFilm, @RequestHeader Long filmIDToLike) {
        return filmService.likeFilm(userIDWhoLikedFilm, filmIDToLike);
    }

    //--------------------Get Mapping------------------------------------------------------------------------

    @GetMapping("/listFilms")
    public List<Film> listFilms() {
        return filmService.listFilms();
    }

}
