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
    private UserDao userDao;

    @Test
    public void findUserByID() {
        List<Map<String, Object>> users = userDao.listUsersFromUserDB();

        assertThat(users.size())
                .isEqualTo(5);
    }
}
