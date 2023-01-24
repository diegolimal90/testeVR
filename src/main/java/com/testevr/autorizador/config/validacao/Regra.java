package com.testevr.autorizador.config.validacao;

public interface Regra<T, U> {
    boolean validar(T objeto, U comparavel);

    void error();
}
