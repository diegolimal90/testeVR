package com.testevr.autorizador.entrypoint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testevr.autorizador.entrypoint.dto.CartaoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CartoesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void criarCartao_success() throws Exception {
        CartaoRequest cartao = new CartaoRequest("30252323026386", "2023");
        mockMvc.perform(post("/v1/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isCreated());
    }

    @Test
    void novoCartao_exixtente() throws Exception {
        CartaoRequest cartao = new CartaoRequest("30077415411323", "2024");
        mockMvc.perform(post("/v1/cartoes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartao)));
        mockMvc.perform(post("/v1/cartoes").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartao)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.numeroCartao", is("30077415411323")));
    }

    @Test
    void consultarSeuSaldo_success() throws Exception {
        CartaoRequest cartao = new CartaoRequest("30077415411323", "2024");
        mockMvc.perform(post("/v1/cartoes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartao)));

        mockMvc.perform(get("/v1/cartoes/"+cartao.getNumeroCartao()).contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("500.00"));
    }

    @Test
    void consultarSaldo_cartaoNaoEncontrado() throws Exception {
        CartaoRequest cartao = new CartaoRequest("30077415411327", "2024");
        mockMvc.perform(post("/v1/cartoes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartao)));

        mockMvc.perform(get("v1/cartoes/2213213213213").contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isNotFound());
    }
}

