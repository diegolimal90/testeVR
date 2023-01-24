package com.testevr.autorizador.provider;

import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.gateway.CartaoGateway;
import com.testevr.autorizador.provider.entity.CartaoEntity;
import com.testevr.autorizador.provider.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoProvider implements CartaoGateway {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao buscarCartaoPorNumeroCartao(String numeroCartao) {

        return cartaoRepository.findById(numeroCartao)
                .map(CartaoEntity::to)
                .orElse(null);
    }

    @Override
    public void criarCartao(Cartao cartao) {
        cartaoRepository.save(CartaoEntity.from(cartao));
    }

    @Override
    public void atualizarCartao(Cartao cartao) {
        cartaoRepository.save(CartaoEntity.from(cartao));
    }
}
