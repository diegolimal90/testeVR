package com.testevr.autorizador.entrypoint.dto;

import com.testevr.autorizador.core.domain.Transacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest implements Serializable {
    private String numeroCartao;
    private String senhaCartao;
    private BigDecimal valor;

    public static TransacaoRequest from(Transacao transacao){
        return Optional.ofNullable(transacao).map(domain ->
                        TransacaoRequest.builder()
                                .numeroCartao(domain.getNumeroCartao())
                                .senhaCartao(domain.getSenhaCartao())
                                .valor(domain.getValor())
                                .build())
                .orElse(new TransacaoRequest());
    }

    public Transacao to(){
        return Optional.ofNullable(this).map( httpModel ->
                        Transacao.builder()
                                .numeroCartao(httpModel.getNumeroCartao())
                                .senhaCartao(httpModel.getSenhaCartao())
                                .valor(httpModel.getValor())
                                .build())
                .orElse(new Transacao());
    }
}
