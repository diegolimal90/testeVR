package com.testevr.autorizador.core.business;

import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.config.validacao.CartaoValidator;
import com.testevr.autorizador.core.gateway.CartaoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class CartaoBusiness {

    @Autowired
    private CartaoGateway cartaoProvider;

    public static BigDecimal SALDO_INICIAL = BigDecimal.valueOf(500);

    @Transactional
    public Cartao criarCartao(Cartao cartao) {
        Cartao cartaoSalvo = cartaoProvider.buscarCartaoPorNumeroCartao(cartao.getNumeroCartao());
        CartaoValidator.validadorNovoCartao().validarRegras(cartaoSalvo, cartao);
        cartao.setSaldo(SALDO_INICIAL);
        cartaoProvider.criarCartao(cartao);
        return cartao;
    }

    public BigDecimal consultarSaldo(String numeroCartao) {
        Cartao cartao = cartaoProvider.buscarCartaoPorNumeroCartao(numeroCartao);
        CartaoValidator.validadorSaldoCartao().validarRegras(cartao, numeroCartao);
        return cartao.getSaldo();
    }
}
