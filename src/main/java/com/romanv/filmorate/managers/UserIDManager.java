package com.romanv.filmorate.managers;

public class UserIDManager {
    private static long id = 1000;

    public static long generateNewId() {
        return ++id;
    }
}
