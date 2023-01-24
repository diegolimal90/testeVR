package com.testevr.autorizador.config.validacao;

import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;

public class TransacaoValidator {

    public static Validador<Cartao, Transacao> validadorTransacao(){
        Validador<Cartao, Transacao> validador = new Validador();
        validador.adicionarRegra(new RegraTransacaoInvalidaCartaoNaoExiste());
        validador.adicionarRegra(new RegraTransacaoInvalidaSaldoInsuficiente());
        validador.adicionarRegra(new RegraTransacaoInvalidaSenhaInvalida());
        return validador;
    }

}
