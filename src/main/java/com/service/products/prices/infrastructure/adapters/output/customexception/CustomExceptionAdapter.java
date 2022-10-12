package com.service.products.prices.infrastructure.adapters.output.customexception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.products.prices.domain.exception.PriceNotFoundException;
import com.service.products.prices.infrastructure.adapters.output.customexception.data.response.ExceptionResponse;

@ControllerAdvice
@RestController
public class CustomExceptionAdapter extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), Arrays.asList(request.getDescription(false)));
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(PriceNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), Arrays.asList(request.getDescription(false)));
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "Validation Failed", errors);
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
}
