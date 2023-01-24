package com.testevr.autorizador.core.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class CartaoDomainTest {

    @Test
    void saldoSomarValor(){
        Cartao cartao = new Cartao();
        cartao.setSaldo(BigDecimal.ZERO);
        cartao.adicionarValor(new BigDecimal(100));
        assertEquals(new BigDecimal(100), cartao.getSaldo());
    }

    @Test
    void saldoSubitraido(){
        Cartao cartao = new Cartao();
        cartao.setSaldo(new BigDecimal(100));
        cartao.subtrairValor(new BigDecimal(50));
        assertEquals(new BigDecimal(50), cartao.getSaldo());
    }

    @Test
    void saldoPossuiValor(){
        Cartao cartao = new Cartao();
        cartao.setSaldo(new BigDecimal(50));
        assertTrue(cartao.possuiValor(new BigDecimal(50)));
    }

    @Test
    void saldoNaoPossuiValor(){
        Cartao cartao = new Cartao();
        cartao.setSaldo(new BigDecimal(500));
        assertFalse(cartao.possuiValor(new BigDecimal(501)));
    }

}