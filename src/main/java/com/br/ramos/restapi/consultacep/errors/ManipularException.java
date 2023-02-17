package com.br.ramos.restapi.consultacep.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ManipularException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            BadRequest ex) {
        return new ResponseEntity<>(new ErrorMessage("CEP ínvalido", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

}