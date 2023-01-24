package com.testevr.autorizador.entrypoint.handler;

import com.testevr.autorizador.config.excecao.TransacaoCartaoInexistenteException;
import com.testevr.autorizador.config.excecao.TransacaoSaldoInsuficienteException;
import com.testevr.autorizador.config.excecao.TransacaoSenhaInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransacaoExceptionController {

    @ExceptionHandler(value = TransacaoCartaoInexistenteException.class)
    public ResponseEntity<Object> exception(TransacaoCartaoInexistenteException exception) {
        return new ResponseEntity<>("Cartao Inexistente.", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = TransacaoSaldoInsuficienteException.class)
    public ResponseEntity<Object> exception(TransacaoSaldoInsuficienteException exception) {
        return new ResponseEntity<>("Saldo Insuficiente.", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = TransacaoSenhaInvalidaException.class)
    public ResponseEntity<Object> exception(TransacaoSenhaInvalidaException exception) {
        return new ResponseEntity<>("Senha Invalida.", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
