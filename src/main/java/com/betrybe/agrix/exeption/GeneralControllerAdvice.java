package com.betrybe.agrix.exeption;

import com.betrybe.agrix.exeption.FertilizerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Handler;


@ControllerAdvice
public class GeneralControllerAdvice {
  Handler Exception; @ExceptionHandler
  public ResponseEntity<String> handlerNotFoundException(FertilizerException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}