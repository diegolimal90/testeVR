package com.testevr.autorizador.config.validator;

import com.testevr.autorizador.config.exception.CartaoExistenteException;
import com.testevr.autorizador.core.domain.Cartao;

public class RegraCartaoExistente implements Regra<Cartao, Cartao>{

    Cartao cartao;

    @Override
    public boolean validar(Cartao cartao, Cartao comparavel) {
        this.cartao = comparavel;
        return cartao != null;
    }

    @Override
    public void error() {
        throw new CartaoExistenteException(this.cartao);
    }
}
