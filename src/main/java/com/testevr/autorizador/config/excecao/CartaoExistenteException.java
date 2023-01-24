package com.testevr.autorizador.config.excecao;

import com.testevr.autorizador.core.domain.Cartao;

public class CartaoExistenteException extends IllegalArgumentException {
    Cartao cartao;

    public CartaoExistenteException(Cartao cartao){
        this.cartao = cartao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
