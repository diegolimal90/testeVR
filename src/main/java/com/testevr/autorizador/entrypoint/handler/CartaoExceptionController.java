package com.testevr.autorizador.entrypoint.handler;

import com.testevr.autorizador.config.excecao.CartaoExistenteException;
import com.testevr.autorizador.config.excecao.CartaoInexistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartaoExceptionController {

    @ExceptionHandler(value = CartaoExistenteException.class)
    public ResponseEntity<Object> exception(CartaoExistenteException exception) {
        return new ResponseEntity<>(exception.getCartao(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = CartaoInexistenteException.class)
    public ResponseEntity<Object> exception() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
