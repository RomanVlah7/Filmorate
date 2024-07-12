package com.romanv.filmorate.controllers;

import com.romanv.filmorate.model.Film;
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

    private FilmService filmService;

    //----------------Post Mapping-----------------------------------------------------------------------

    @PostMapping("/addFilm")
    public void addFilm(@RequestParam String title, @RequestParam String description) {
            filmService.addFilm(title, description);
    }

    //--------------------Patch Mapping------------------------------------------------------------------------

    @PatchMapping("/editFilm")
    public void updateFilmData(@RequestParam Long filmID, @RequestParam String newTitle,
                               @RequestParam String newDescription) {
        filmService.updateFilmData(filmID, newTitle, newDescription);
    }

    @PatchMapping("/likeFilm")
    public ResponseEntity<Map<String, String>> likeTheFilm(@RequestParam Long filmIDToLike) {
        filmService.likeFilm(filmIDToLike);
        return null;
    }

    //--------------------Get Mapping------------------------------------------------------------------------

    @GetMapping("/listFilms")
    public List<Map<String, Object>> listFilms() {
        return filmService.listFilms();
    }

}
