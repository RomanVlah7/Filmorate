package com.romanv.filmorate.controllers;

import com.romanv.filmorate.model.User;
import com.romanv.filmorate.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //------------------Post Mapping-----------------------------------------------------------------------------
    @PostMapping("/addUser")
    public void addUser(@RequestParam String name, @RequestParam String login) {
        userService.addUser(name, login);
    }

    //-------------------Patch Mapping-----------------------------------------------------------------------

    @PatchMapping("/updateUserData")
    public void updateUserData(@RequestParam String userID, @RequestParam String name, @RequestParam String login) {
        userService.editUserData(userID, name, login);
    }

    @PatchMapping("/mutualAdditionToFriends")
    public ResponseEntity<Map<String, String>> mutualAdditionToFriends(User user1, User user2) {
        return userService.mutualAdditionToFriends(user1, user2);
    }

    @PatchMapping("/deleteUser")
    public void deleteUser(Long userID) {
        userService.deleteUser(userID);
    }

    //-------------------Get Mapping-------------------------------------------------------------------------------

    @GetMapping("/getUsers")
    public List<Map<String, Object>> getUsers() {
        return userService.listUsers();
    }
}