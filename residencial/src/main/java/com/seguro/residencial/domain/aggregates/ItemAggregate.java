package com.seguro.residencial.domain.aggregates;

import com.seguro.residencial.domain.commands.itens.RegistrarItemCommand;
import com.seguro.residencial.domain.events.itens.ItemRegistradoEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @criado 05/11/2020 - 19:17
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Aggregate
@NoArgsConstructor
@Getter
public class ItemAggregate {


    @AggregateIdentifier
    private String id;
    private String codigoCotacao;
    private Long idTipoRisco;
    private Long idPacoteCobertura;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;


    @CommandHandler
    public ItemAggregate(RegistrarItemCommand command) {
        AggregateLifecycle.apply(new ItemRegistradoEvent(command.getId(), command.getIdCotacao(),
                command.getTipoRisco(),command.getIdPacoteCobertura(),
                command.getLogradouro(), command.getNumero(),
                command.getComplemento(), command.getCidade(),
                command.getUf(), command.getCep()));
    }

    @EventSourcingHandler
    protected void on(ItemRegistradoEvent event) {
        this.id = event.getId();
        this.codigoCotacao = event.getCodigoCotacao();
        this.logradouro = event.getLogradouro();
        this.idTipoRisco = event.getTipoRisco().getId();
        this.idPacoteCobertura = event.getIdPacoteCobertura();
        this.numero = event.getNumero();
        this.complemento = event.getComplemento();
        this.cidade = event.getCidade();
        this.uf = event.getUf();
        this.cep = event.getCep();
    }
}
