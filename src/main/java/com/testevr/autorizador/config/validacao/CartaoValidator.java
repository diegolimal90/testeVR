package com.testevr.autorizador.config.validacao;

import com.testevr.autorizador.core.domain.Cartao;

public class CartaoValidator {


    public static Validador<Cartao, Cartao> validadorNovoCartao(){
        Validador<Cartao, Cartao> validador = new Validador();
        validador.adicionarRegra(new RegraCartaoJaExiste());
        return validador;
    }

    public static Validador<Cartao, String> validadorSaldoCartao(){
        Validador<Cartao, String> validador = new Validador();
        validador.adicionarRegra(new RegraCartaoNaoEncontrado());
        return validador;
    }


}
