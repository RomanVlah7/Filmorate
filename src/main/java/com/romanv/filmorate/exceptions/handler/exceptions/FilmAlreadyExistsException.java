package com.romanv.filmorate.exceptions.handler.exceptions;

public class FilmAlreadyExistsException extends Exception{
    public FilmAlreadyExistsException(){
        super("Film Already Exists");
    }
}
