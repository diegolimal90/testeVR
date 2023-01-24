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
public class Cartao implements Serializable {

    private String numeroCartao;
    private String senha;
    private BigDecimal saldo;
    private Long idSaldo;

    public void adicionarValor(BigDecimal saldo){
        this.saldo = this.saldo.add(saldo);
    }

    public void subtrairValor(BigDecimal saldo){
        this.saldo = this.saldo.subtract(saldo);
    }

    public boolean possuiValor(BigDecimal saldo){
        return this.saldo.compareTo(saldo) >= 0;
    }
}