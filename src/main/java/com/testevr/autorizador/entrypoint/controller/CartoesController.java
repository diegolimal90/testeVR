package com.testevr.autorizador.entrypoint.controller;

import com.sun.istack.NotNull;
import com.testevr.autorizador.core.business.CartaoBusiness;
import com.testevr.autorizador.core.domain.Cartao;
import com.testevr.autorizador.entrypoint.dto.CartaoRequest;
import com.testevr.autorizador.entrypoint.dto.CartaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("v1/cartoes")
public class CartoesController {

    @Autowired
    private CartaoBusiness cartaoBusiness;

    @PostMapping
    public ResponseEntity<CartaoResponse> criarCartao(@RequestBody CartaoRequest cartaoRequest) {
        Cartao cartao = cartaoBusiness.criarCartao(cartaoRequest.to());
        return new ResponseEntity<>(CartaoResponse.from(cartao), HttpStatus.CREATED);
    }

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<BigDecimal> obterSaldo(@PathVariable @NotNull String numeroCartao) {
        BigDecimal saldo = cartaoBusiness.consultarSaldo(numeroCartao);
        return new ResponseEntity<>(saldo, HttpStatus.OK);
    }

}
