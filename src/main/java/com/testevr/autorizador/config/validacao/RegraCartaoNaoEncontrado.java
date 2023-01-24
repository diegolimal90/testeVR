package com.testevr.autorizador.config.validacao;

import com.testevr.autorizador.config.excecao.CartaoInexistenteException;
import com.testevr.autorizador.core.domain.Cartao;

import java.util.Objects;

public class RegraCartaoNaoEncontrado implements Regra<Cartao, String>{

    @Override
    public boolean validar(Cartao cartao, String numeroCartao) {
        return Objects.isNull(cartao);
    }

    @Override
    public void error() {
        throw new CartaoInexistenteException();
    }


}
