package com.testevr.autorizador.config.validacao;

import com.testevr.autorizador.config.excecao.CartaoExistenteException;
import com.testevr.autorizador.core.domain.Cartao;

public class RegraCartaoJaExiste implements Regra<Cartao, Cartao>{

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
