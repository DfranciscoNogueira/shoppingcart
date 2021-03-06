package br.com.plataformat.shoppingcart.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.plataformat.shoppingcart.exception.EntityNotFoundException;

@ControllerAdvice
public class NotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(EntityNotFoundException ex) {
      return ex.getMessage();
    }

}
