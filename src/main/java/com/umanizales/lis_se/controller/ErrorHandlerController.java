package com.umanizales.lis_se.controller;

import com.umanizales.lis_se.Exception.ListaSeException;
import com.umanizales.lis_se.controller.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ListaSeException.class)
    protected ResponseEntity<?> handle(ListaSeException ex)
    {
        String message = ex.getMessage();
        ResponseDTO response = new ResponseDTO(message,null,null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
