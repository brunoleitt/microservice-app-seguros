package com.seguro.residencial.web.api.controller;

import com.seguro.residencial.application.interfaces.ICotacaoQueryAppService;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping("v1/residencial/consulta")
@Slf4j
@Api(value = "Endpoints para consultas de cotações residencial")
public class CotacaoQueryController {

    private final ICotacaoQueryAppService iCotacaoQueryAppService;

    public CotacaoQueryController(ICotacaoQueryAppService iCotacaoQueryAppService) {
        this.iCotacaoQueryAppService = iCotacaoQueryAppService;
    }

    @GetMapping("/{idCotacao}")
    public CompletableFuture<CotacaoRoot> criarCotacao(@PathVariable("idCotacao") String idCotacao){
        return this.iCotacaoQueryAppService.findById(idCotacao);
    }

    @GetMapping("/{idCotacao}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "idCotacao") String idCotacao) {
        return this.iCotacaoQueryAppService.listEventsForAccount(idCotacao);
    }
}
