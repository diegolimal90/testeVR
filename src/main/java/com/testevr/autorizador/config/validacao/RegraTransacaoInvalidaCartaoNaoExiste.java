package com.testevr.autorizador.config.validacao;

import com.testevr.autorizador.config.excecao.TransacaoCartaoInexistenteException;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

import java.util.Objects;

public class RegraTransacaoInvalidaCartaoNaoExiste implements Regra<Cartao, Transacao>{

    @Override
    public boolean validar(Cartao cartao, Transacao transacao) {
        return Objects.isNull(cartao);
    }

    @Override
    public void error() {
        throw new TransacaoCartaoInexistenteException();
    }


}
