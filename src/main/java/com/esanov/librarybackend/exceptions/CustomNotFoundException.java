package com.esanov.librarybackend.exceptions;

import lombok.Getter;

@Getter
public class CustomNotFoundException extends Exception {

    public CustomNotFoundException(String message) {
        super(message);
    }
}
