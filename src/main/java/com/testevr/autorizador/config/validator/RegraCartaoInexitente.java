package com.testevr.autorizador.config.validator;

import com.testevr.autorizador.config.exception.CartaoInexistenteException;
import com.testevr.autorizador.core.domain.Cartao;

import java.util.Objects;

public class RegraCartaoInexitente implements Regra<Cartao, String>{

    @Override
    public boolean validar(Cartao cartao, String numeroCartao) {
        return Objects.isNull(cartao);
    }

    @Override
    public void error() {
        throw new CartaoInexistenteException();
    }


}
