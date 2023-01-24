package com.testevr.autorizador.core.gateway;

import com.testevr.autorizador.core.domain.Cartao;

public interface CartaoGateway {

    Cartao buscarCartaoPorNumeroCartao(String numeroCartao);

    void criarCartao(Cartao cartao);

    void atualizarCartao(Cartao cartao);
}
