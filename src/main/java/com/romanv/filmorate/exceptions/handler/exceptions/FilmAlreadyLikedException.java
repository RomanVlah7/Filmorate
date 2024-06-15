package com.romanv.filmorate.exceptions.handler.exceptions;

public class FilmAlreadyLikedException extends Exception{
    public FilmAlreadyLikedException(){
        super("Film Already Liked");
    }
}
