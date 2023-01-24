package com.testevr.autorizador.core.gateway;

import com.testevr.autorizador.core.domain.Transacao;
import org.springframework.stereotype.Service;

@Service
public interface TransacaoGateway {
    void subtrairSaldo(Transacao transacao);
}
