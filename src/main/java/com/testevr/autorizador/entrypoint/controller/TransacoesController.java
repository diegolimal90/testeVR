package com.testevr.autorizador.entrypoint.controller;

import com.testevr.autorizador.core.business.TransacaoBusiness;
import com.testevr.autorizador.entrypoint.dto.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/transacoes")
public class TransacoesController {

    @Autowired
    private TransacaoBusiness transacaoBusiness;

    @PostMapping
    public ResponseEntity<String> efetuarTransacao(@RequestBody TransacaoRequest transacaoRequest) {
        transacaoBusiness.subtrairSaldo(transacaoRequest.to());
        return ResponseEntity.ok("Transação efetuada com sucesso.");
    }
}
