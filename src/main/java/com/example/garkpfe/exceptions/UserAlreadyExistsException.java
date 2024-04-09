package com.example.garkpfe.exceptions;

public class UserAlreadyExistsException  extends RuntimeException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }

}
