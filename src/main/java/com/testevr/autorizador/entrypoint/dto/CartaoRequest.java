package com.testevr.autorizador.entrypoint.dto;

import com.testevr.autorizador.core.domain.Cartao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartaoRequest implements Serializable {

    private String numeroCartao;
    private String senha;

    public static CartaoRequest from(Cartao cartao) {
        return Optional.ofNullable(cartao).map( domain ->
                CartaoRequest.builder()
                        .numeroCartao(domain.getNumeroCartao())
                        .senha(domain.getSenha())
                        .build())
                .orElse(new CartaoRequest());
    }

    public Cartao to() {
        return Optional.ofNullable(this).map( httpModel ->
                        Cartao.builder()
                                .numeroCartao(httpModel.getNumeroCartao())
                                .senha(httpModel.getSenha())
                                .build())
                .orElse(new Cartao());
    }
}