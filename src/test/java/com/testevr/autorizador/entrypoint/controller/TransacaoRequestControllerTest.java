package com.testevr.autorizador.entrypoint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testevr.autorizador.core.domain.Transacao;
import com.testevr.autorizador.entrypoint.dto.CartaoRequest;
import com.testevr.autorizador.provider.repository.CartaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TransacaoRequestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CartaoRepository cartaoRepository;

    @BeforeEach
    void setup() throws Exception {
        CartaoRequest cartao = new CartaoRequest("30252323026386", "2023");
        mockMvc.perform(post("/v1/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isCreated());
    }

    @Test
    void criarUmaTransacao_success() throws Exception {
        Transacao transacao = new Transacao("30252323026386", "2023", new BigDecimal("10.00"));
        mockMvc.perform(post("/v1/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacao)))
                .andExpect(status().isOk());
    }

    @Test
    void criarUmaTransacao_cartaoInexistente() throws Exception {
        Transacao transacao = new Transacao("654987302563501", "2023", new BigDecimal("10.00"));
        mockMvc.perform(post("/v1/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacao)))
                .andExpect(content().string("Cartao Inexistente."))
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    void criarUmaTransacao_saldoInsuficiente() throws Exception {
        Transacao transacao = new Transacao("30252323026386", "2023", new BigDecimal("501.00"));
        mockMvc.perform(post("/v1/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacao)))
                .andExpect(content().string("Saldo Insuficiente."))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void criarUmaTransacao_senhaInvalida() throws Exception {
        Transacao transacao = new Transacao("30252323026386", "1231", new BigDecimal("500.00"));
        mockMvc.perform(post("/v1/transacoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transacao)))
                .andExpect(content().string("Senha Invalida."))
                .andExpect(status().isUnprocessableEntity());
    }

}

