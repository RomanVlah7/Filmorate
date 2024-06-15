package com.romanv.filmorate.exceptions.handler.exceptions;

public class FilmNotFoundException extends Exception{
    public FilmNotFoundException(){
        super("Film Not Found");
    }
}
