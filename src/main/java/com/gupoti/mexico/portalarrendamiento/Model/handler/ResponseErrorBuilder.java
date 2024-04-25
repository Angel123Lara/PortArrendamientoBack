package com.gupoti.mexico.portalarrendamiento.Model.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import jakarta.persistence.EntityNotFoundException;
public class ResponseErrorBuilder {
    
    private int status;

    private Map<String, String> errors;

    private String ruta;

    public ResponseErrorBuilder status (int status){
        this.status = status;
        return this;
    }

    public ResponseErrorBuilder errores(Map<String,String> error){
        this.errors = error;
        return this;
    }

    public ResponseErrorBuilder exceptions(MethodArgumentNotValidException ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        this.status = status.value();
        this.errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return this;
    }

    public ResponseErrorBuilder ruta(String ruta){
        this.ruta = ruta;
        return this;
    }

    public ResponseError build(){
        ResponseError response = new ResponseError();
        response.setStatus(this.status);
        response.setErrores(this.errors);
        response.setRuta(this.ruta);
        return response;
    }

    public ResponseEntity<ResponseError> entity(){
        return ResponseEntity.status(status)
                            .headers(HttpHeaders.EMPTY)    
                            .body(build());
    }

    //new Exception
    public ResponseErrorBuilder exceptions(EntityNotFoundException ex){
        HttpStatus status = HttpStatus.NOT_FOUND;
        this.status = status.value();
        this.errors = new HashMap<>();

        String fieldName = "Error";
        String errorMessage = ex.getMessage();

        errors.put(fieldName, errorMessage);
        return this;
    }

    public ResponseErrorBuilder exceptions(HttpMessageNotReadableException ex){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        this.status = status.value();
        this.errors = new HashMap<>();
        Throwable mostSpecificCause = ex.getMostSpecificCause();

        if (mostSpecificCause instanceof InvalidFormatException) {
            InvalidFormatException ife = (InvalidFormatException) mostSpecificCause;
            errors.put("InvalidValue", ife.getMessage());
        } else {
            errors.put("Error", ex.getMessage());
        }    
        return this;
    }

    public ResponseErrorBuilder exceptions(DataIntegrityViolationException ex){
        HttpStatus status = HttpStatus.CONFLICT;
        this.status = status.value();
        this.errors = new HashMap<>();

        String fieldName = "ErrorValue";
        String errorMessage = ex.getMessage();

        errors.put(fieldName, errorMessage);
        return this;
    }
}
