package com.seguro.residencial.web.api.controller.cotacoes;


import com.seguro.residencial.application.models.input.CriarCotacaoInput;
import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.models.view.CotacaoCriadaViewModel;
import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.exception.EntidadeNaoEncontradaException;
import com.seguro.residencial.domain.exception.NegocioException;
import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @criado 16/09/2020 - 00:33
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RestController
@RequestMapping(path = "v1/residencial/cotacao",  produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Api(value = "Endpoints para gerenciar cotacoes residencial")
public class CotacaoController {

    private final ICotacaoAppService iCotacaoAppService;

    public CotacaoController(ICotacaoAppService _iCotacaoAppService) {
        this.iCotacaoAppService = _iCotacaoAppService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CotacaoCriadaViewModel criarCotacao(@RequestBody CriarCotacaoInput criarCotacaoInput){
         return iCotacaoAppService.criacaoCotacao(criarCotacaoInput);
    }
}
