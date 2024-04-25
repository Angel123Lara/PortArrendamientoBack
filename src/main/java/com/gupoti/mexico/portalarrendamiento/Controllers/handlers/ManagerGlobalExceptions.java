package com.gupoti.mexico.portalarrendamiento.Controllers.handlers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.gupoti.mexico.portalarrendamiento.Model.handler.ResponseError;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ManagerGlobalExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException (MethodArgumentNotValidException ex,
                                                    WebRequest request){
        return ResponseError.builder()
                            .exceptions(ex)
                            .ruta(request.getDescription(false).substring(4))
                            .entity();
                        }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleStatusException (EntityNotFoundException ex,
                                                    WebRequest request){
        return ResponseError.builder()
                            .exceptions(ex)
                            .ruta(request.getDescription(false).substring(4))
                            .entity();                                
                            }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleStatusException (HttpMessageNotReadableException ex,
                                                    WebRequest request){
        return ResponseError.builder()
                            .exceptions(ex)
                            .ruta(request.getDescription(false).substring(4))
                            .entity();
                                                    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleStatusException (DataIntegrityViolationException ex,
                                                    WebRequest request){
        return ResponseError.builder()
                            .exceptions(ex)
                            .ruta(request.getDescription(false).substring(4))
                            .entity();
                                                    }
}
