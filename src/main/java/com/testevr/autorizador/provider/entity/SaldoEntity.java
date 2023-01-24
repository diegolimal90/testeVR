package com.testevr.autorizador.provider.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tbl_saldo")
public class SaldoEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(name = "nr_valor")
    private BigDecimal valor;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updateDateTime;
}
