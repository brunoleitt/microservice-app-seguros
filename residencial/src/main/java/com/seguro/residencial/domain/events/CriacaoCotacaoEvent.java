package com.seguro.residencial.domain.events;

import com.seguro.residencial.coreapi.model.baseevent.BaseEvent;
import com.seguro.residencial.domain.models.root.clientes.ClienteRoot;
import com.seguro.residencial.domain.models.root.cotacoes.TipoCalculo;
import com.seguro.residencial.domain.models.root.cotacoes.TipoVigencia;
import com.seguro.residencial.domain.models.root.itens.ItemRoot;
import com.seguro.residencial.domain.models.root.questionarios.QuestionarioRoot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @criado 12/10/2020 - 14:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 *
 *
 * Contem todas as informações para criação da cotação
 *  - Propedidades com dados validar para realizar o mapeamento com entidade de modelo.
 *  - Propeidades com os dados necessario para cricao de uma nova contação
 */
@Getter
@Setter
public class CriacaoCotacaoEvent extends BaseEvent {


    public CriacaoCotacaoEvent(Long id,
                               OffsetDateTime dataCotacao,
                               OffsetDateTime dataVigenciaInicial,
                               OffsetDateTime dataVigenciaFinal,
                               Integer idTipoCalculo,
                               Integer idTipoVigencia,
                               ItemRoot item,
                               QuestionarioRoot questionario,
                               ClienteRoot cliente) {
        super(id);
        this.dataCotacao = dataCotacao;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.idTipoCalculo = idTipoCalculo;
        this.idTipoVigencia = idTipoVigencia;
        this.item = item;
        this.questionario = questionario;
        this.cliente = cliente;
    }

    private OffsetDateTime dataCotacao;

    private OffsetDateTime dataVigenciaInicial;

    private OffsetDateTime dataVigenciaFinal;

    private Integer idTipoCalculo;

    private Integer idTipoVigencia;

    private ItemRoot item;

    private QuestionarioRoot questionario;

    private ClienteRoot cliente;

}
