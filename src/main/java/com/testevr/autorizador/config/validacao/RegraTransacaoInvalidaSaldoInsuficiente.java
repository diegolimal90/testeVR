package com.testevr.autorizador.config.validacao;

import com.testevr.autorizador.config.excecao.TransacaoSaldoInsuficienteException;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

import java.util.Objects;

public class RegraTransacaoInvalidaSaldoInsuficiente implements Regra<Cartao, Transacao>{

    @Override
    public boolean validar(Cartao cartao, Transacao transacao) {
        return Objects.nonNull(cartao) && !cartao.possuiValor(transacao.getValor());
    }

    @Override
    public void error() {
        throw new TransacaoSaldoInsuficienteException();
    }
}
