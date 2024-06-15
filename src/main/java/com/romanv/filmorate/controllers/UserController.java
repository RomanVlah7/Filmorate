package com.romanv.filmorate.controllers;

import com.romanv.filmorate.model.User;
import com.romanv.filmorate.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService = new UserService();

    //------------------Post Mapping-----------------------------------------------------------------------------
    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    //-------------------Patch Mapping-----------------------------------------------------------------------

    @PatchMapping("/updateUserData")
    public ResponseEntity<Map<String, String>> updateUserData(@RequestBody User user) {
        return userService.editUserData(user);
    }

    @PatchMapping("/mutualAdditionToFriends")
    public ResponseEntity<Map<String, String>> mutualAdditionToFriends(User user1, User user2) {
        return userService.mutualAdditionToFriends(user1, user2);
    }

    @PatchMapping("/deleteUser")
    public ResponseEntity<Map<String, String>> deleteUser(Long userID) {
        return userService.deleteUser(userID);
    }

    //-------------------Get Mapping-------------------------------------------------------------------------------

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.listUsers();
    }
}