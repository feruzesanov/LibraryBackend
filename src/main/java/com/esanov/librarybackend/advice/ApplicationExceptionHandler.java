package com.esanov.librarybackend.advice;

import com.esanov.librarybackend.exceptions.CustomNotFoundException;
import com.esanov.librarybackend.response.ErrorMessage;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomNotFoundException.class)
    public List<ErrorMessage> handleNotFound(CustomNotFoundException ex){
        List<ErrorMessage> errorList = new ArrayList<>();
        errorList.add(new ErrorMessage(ex.getMessage()));
        return errorList;
    }


}
