package com.testevr.autorizador.config.validator;

public interface Regra<T, U> {
    boolean validar(T objeto, U comparavel);

    void error();
}
