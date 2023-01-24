package com.testevr.autorizador.config.validator;

import com.testevr.autorizador.config.exception.TransacaoCartaoInexistenteException;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

import java.util.Objects;

public class RegraTransacaoCartaoInexistente implements Regra<Cartao, Transacao>{

    @Override
    public boolean validar(Cartao cartao, Transacao transacao) {
        return Objects.isNull(cartao);
    }

    @Override
    public void error() {
        throw new TransacaoCartaoInexistenteException();
    }


}
