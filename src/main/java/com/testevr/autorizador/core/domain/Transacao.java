package com.testevr.autorizador.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao implements Serializable {
    private String numeroCartao;
    private String senhaCartao;
    private BigDecimal valor;
}
