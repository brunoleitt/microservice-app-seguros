package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.cotacao.CriarCotacaoCommand;
import com.seguro.residencial.domain.events.CriadaCotacaoEvent;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @criado 12/10/2020 - 14:16
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Aggregate
@Getter
@Setter
public class CotacaoAggregate {

    @AggregateIdentifier
    private Long id;
    private String codigoCotacao;
    private OffsetDateTime dataCotacao;
    private OffsetDateTime dataVigenciaInicial;
    private OffsetDateTime dataVigenciaFinal;
    private Long idTipoCalculo;
    private Long idTipoVigencia;
    private ItemRoot item;
    private QuestionarioRoot questionario;
    private ClienteRoot cliente;


    @CommandHandler
    public CotacaoAggregate(CriarCotacaoCommand createCotacaoCommand){

          AggregateLifecycle.apply(new CriadaCotacaoEvent(createCotacaoCommand.id,
                                                           createCotacaoCommand.codigoCotacao,
                                                           createCotacaoCommand.getDataCotacao(),
                                                           createCotacaoCommand.getDataVigenciaInicial(),
                                                           createCotacaoCommand.getDataVigenciaFinal(),
                                                           createCotacaoCommand.getIdTipoCalculo(),createCotacaoCommand.getIdTipoVigencia(),
                                                           createCotacaoCommand.getItem(),createCotacaoCommand.getQuestionario(),
                                                           createCotacaoCommand.getCliente()));
    }

    /*Realizar a validação de negocio para criacao de cotacao, antes de realizar a chamada de eventos */
    @EventSourcingHandler
    protected void criarCotacaoEvent(CriadaCotacaoEvent event){

        this.id = event.getId();
        this.codigoCotacao = event.getCodigoCotacao();
        this.dataCotacao = OffsetDateTime.now();
        this.dataVigenciaInicial = OffsetDateTime.now(); // event.getDataVigenciaInicial();
        this.dataVigenciaFinal = OffsetDateTime.now();   //event.getDataVigenciaFinal();
        this.idTipoCalculo = event.getIdTipoCalculo();
        this.idTipoVigencia = event.getIdTipoVigencia();
        this.item = event.getItem();
        this.questionario = event.getQuestionario();
        this.cliente = event.getCliente();
    }

    public CotacaoAggregate() {
    }
}
