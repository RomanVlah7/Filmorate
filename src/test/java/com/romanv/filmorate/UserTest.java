package com.romanv.filmorate;

import com.romanv.filmorate.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findUserByIDtest() {
        List<Map<String, Object>> users = userDao.listUsersFromUserDB();

        assertThat(users.size())
                .isEqualTo(5);
    }

    @Test
    void addNewUserToUserDBtest() {
        userDao.addNewUserToUserDB("Jack", "jjj333");
    }

    @Test
    void deleteUserFromUserDBtest() {
        userDao.deleteUserFromUserDB(1l);
    }

    @Test
    void editUserDataFromDBtest() {
        userDao.editUserDataFromDB("1", "Marko", "marrrr3");
    }
}
