package com.seguro.residencial.application.services;

import com.seguro.residencial.application.interfaces.ICotacaoAppService;
import com.seguro.residencial.application.viewmodels.CriarCotacaoViewModel;
import com.seguro.residencial.domain.commands.cotacao.CriacaoCotacaoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @criado 12/10/2020 - 15:39
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Service
public class CotacaoAppServiceImpl implements ICotacaoAppService {

    private final CommandGateway commandGateway;

    public CotacaoAppServiceImpl(CommandGateway _CommandGateway) {
        this.commandGateway = _CommandGateway;
    }

    @Override
    public CompletableFuture<String> criacaoCotacao(CriarCotacaoViewModel criarCotacaoDTO) {
        return commandGateway.send(new CriacaoCotacaoCommand(UUID.randomUUID().toString(),
                criarCotacaoDTO.getTitulo()));
    }

}
