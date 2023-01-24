package com.testevr.autorizador.config.validator;

import com.testevr.autorizador.config.exception.TransacaoSaldoInsuficienteException;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

import java.util.Objects;

public class RegraTransacaoSaldoInsuficiente implements Regra<Cartao, Transacao>{

    @Override
    public boolean validar(Cartao cartao, Transacao transacao) {
        return Objects.nonNull(cartao) && !cartao.possuiValor(transacao.getValor());
    }

    @Override
    public void error() {
        throw new TransacaoSaldoInsuficienteException();
    }
}
