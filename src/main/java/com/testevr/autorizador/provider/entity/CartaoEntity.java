package com.testevr.autorizador.provider.entity;

import com.testevr.autorizador.core.domain.Cartao;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_cartao")
public class CartaoEntity {
    @Id
    @Column(name = "nr_cartao", nullable = false)
    private String numeroCartao;

    //TODO - Por carater de tempo a senha nao será criptografada.
    @Column(name = "ds_senha", nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private SaldoEntity saldo;

    public static CartaoEntity from(Cartao cartao) {
        return Optional.ofNullable(cartao).map(httpModel ->
                        CartaoEntity.builder()
                                .numeroCartao(httpModel.getNumeroCartao())
                                .senha(httpModel.getSenha())
                                .saldo(
                                        SaldoEntity.builder()
                                                .id(httpModel.getIdSaldo())
                                                .valor(httpModel.getSaldo())
                                                .build()
                                )
                                .build())
                .orElse(new CartaoEntity());
    }

    public Cartao to() {
        return Optional.of(this).map(domain ->
                        Cartao.builder()
                                .numeroCartao(domain.getNumeroCartao())
                                .senha(domain.getSenha())
                                .idSaldo(domain.getSaldo().getId())
                                .saldo(domain.getSaldo().getValor())
                                .build())
                .orElse(new Cartao());
    }
}
