package com.testevr.autorizador.config.validator;

import com.testevr.autorizador.config.exception.TransacaoSenhaInvalidaException;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

import java.util.Objects;

public class RegraTransacaoInvalidaSenhaInvalida implements Regra<Cartao, Transacao>{

    @Override
    public boolean validar(Cartao cartao, Transacao transacao) {
        return Objects.nonNull(cartao) && !cartao.getSenha().equals(transacao.getSenhaCartao());
    }

    @Override
    public void error() {
        throw new TransacaoSenhaInvalidaException();
    }
}
