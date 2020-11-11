package br.dev.marcoalmeida.fileaxemongo.controller;

import br.dev.marcoalmeida.fileaxemongo.exception.FileProcessNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class FileProcessNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(FileProcessNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String fileProcessNotFoundHandler(FileProcessNotFoundException ex) {
    return ex.getMessage();
  }
}
