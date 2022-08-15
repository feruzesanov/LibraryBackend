package com.esanov.librarybackend.exceptions;

import lombok.Getter;

@Getter
public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException(String message) {
        super(message);
    }
}
