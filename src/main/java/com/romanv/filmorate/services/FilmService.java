package com.romanv.filmorate.services;

import com.romanv.filmorate.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class FilmService implements FilmIServiceInterface {

    private final FilmDao filmDao;

    @Autowired
    public FilmService(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public void addFilm(String title, String description) {
        filmDao.addFilmToDB(title, description);
    }

    @Override
    public List<Map<String, Object>> listFilms() {
        return filmDao.listFilmsFromDB();
    }

    @Override
    public void updateFilmData(Long filmID, String newTitle, String newDescription) {
        filmDao.editFilmDataInDB(filmID, newTitle, newDescription);
    }

    @Override
    public void likeFilm(Long filmID) {
        filmDao.likeFilmFromDB(filmID);
    }
}