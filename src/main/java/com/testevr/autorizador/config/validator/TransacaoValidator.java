package com.testevr.autorizador.config.validator;

import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

public class TransacaoValidator {

    public static Validador<Cartao, Transacao> validadorTransacao(){
        Validador<Cartao, Transacao> validador = new Validador();
        validador.adicionarRegra(new RegraTransacaoCartaoInexistente());
        validador.adicionarRegra(new RegraTransacaoSaldoInsuficiente());
        validador.adicionarRegra(new RegraTransacaoInvalidaSenhaInvalida());
        return validador;
    }

}
