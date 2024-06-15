package com.romanv.filmorate.exceptions.handler;

import com.romanv.filmorate.exceptions.handler.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {


    @ResponseBody
    @ExceptionHandler
    public static ResponseEntity<Map<String, String>> invalidDataException(InvalidDataException e) {
        return new ResponseEntity<>(
                Map.of(e.getMessage(), "400"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public static ResponseEntity<Map<String, String>> userAlreadyExists(UserAlreadyExistsException e) {
        return new ResponseEntity<>(
                Map.of(e.getMessage(), "400"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public static ResponseEntity<Map<String, String>> userNotFound(UserNotFoundException e) {
        return new ResponseEntity<>(
                Map.of(e.getMessage(), "400"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public static ResponseEntity<Map<String, String>> filmAlreadyExists(FilmAlreadyExistsException e) {
        return new ResponseEntity<>(
                Map.of(e.getMessage(), "400"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public static ResponseEntity<Map<String, String>> filmNotFound(FilmNotFoundException e) {
        return new ResponseEntity<>(
                Map.of(e.getMessage(), "400"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public static ResponseEntity<Map<String, String>> filmAlreadyLiked(FilmAlreadyLikedException e) {
        return new ResponseEntity<>(
                Map.of(e.getMessage(), "400"),
                HttpStatus.BAD_REQUEST
        );
    }
}
