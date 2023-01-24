package com.testevr.autorizador.core.business;

import com.testevr.autorizador.config.validator.TransacaoValidator;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.core.domain.Transacao;
import com.testevr.autorizador.core.gateway.CartaoGateway;
import com.testevr.autorizador.provider.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransacaoBusiness {

    @Autowired
    private CartaoGateway cartaoGateway;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Transactional
    public void subtrairSaldo(Transacao transacao) {
        Cartao cartaoSalvo = cartaoGateway.buscarCartaoPorNumeroCartao(transacao.getNumeroCartao());
        TransacaoValidator.validadorTransacao().validarRegras(cartaoSalvo, transacao);
        cartaoSalvo.subtrairValor(transacao.getValor());
        cartaoGateway.atualizarCartao(cartaoSalvo);
    }

}
