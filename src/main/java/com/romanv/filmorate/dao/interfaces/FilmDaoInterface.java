package com.romanv.filmorate.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface FilmDaoInterface {
    void addFilmToDB(String title, String description);

    void deleteFilmFromDB(Long filmID);

    void likeFilmFromDB(Long filmID);

    void removeLikeForFilmFromDB(Long filmID);

    List<Map<String,Object>> listFilmsFromDB();

    List<Map<String,Object>> listTopTenFromDB();

    void editFilmDataInDB(Long filmID, String newTitle, String newDescription);
}
