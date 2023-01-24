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
public class CartaoResponse implements Serializable {

    private String numeroCartao;

    public static CartaoResponse from(Cartao cartao) {
        return Optional.ofNullable(cartao).map( domain ->
                CartaoResponse.builder()
                        .numeroCartao(domain.getNumeroCartao())
                        .build())
                .orElse(new CartaoResponse());
    }
}