package com.romanv.filmorate.exceptions.handler.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("User already exists");
    }
}
