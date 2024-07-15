package com.romanv.filmorate;

import com.romanv.filmorate.dao.FilmDao;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FilmTest {

    @Autowired
    private FilmDao filmDao;

    @Test
    public void listAllFilmsFromDBtest(){
        List<Map<String, Object>> allFilms = filmDao.listFilmsFromDB();
        assertThat(allFilms.size())
                .isEqualTo(4);
    }

    @Test
    public void listTopTenFilmsFromDBtest(){
        List<Map<String, Object>> topTenFromDB = filmDao.listTopTenFromDB();
        assertThat(topTenFromDB.size())
                .isEqualTo(4);
    }

    @Test
    void addFilmToDBtest() {
        filmDao.addFilmToDB("Titanic2", "not exists");
    }

    @Test
    void deleteFilmFromDBtest() {
        filmDao.deleteFilmFromDB(1l);
    }

    @Test
    void likeFilmFromDBtest() {
        filmDao.likeFilmFromDB(1l);
    }

    @Test
    void removeLikeForFilmFromDBtest() {
        filmDao.removeLikeForFilmFromDB(1l);
    }

    @Test
    void editFilmDataInDBtest() {
        filmDao.editFilmDataInDB(1l, "New Titanic", "This film is bad");
    }
}
