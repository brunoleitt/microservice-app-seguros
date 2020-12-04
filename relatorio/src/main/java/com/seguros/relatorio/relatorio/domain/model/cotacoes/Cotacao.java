package com.seguros.relatorio.relatorio.domain.model.cotacoes;

import com.seguros.relatorio.relatorio.application.models.views.itens.ItemViewModel;
import com.seguros.relatorio.relatorio.domain.model.itens.ItemRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.annotation.Id;

/**
 * @criado 02/12/2020 - 09:44
 * @projeto Seguro Impressão
 * @autor Bruno Leite
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cotacao {

    @Id
    private String codigoCotacao;
    private String dataCotacao;
    private String dataVigenciaInicial;
    private String dataVigenciaFinal;
    private String statusCotacao;
    private String tipoCalculo;
    private String tipoVigencia;
    private ItemRoot item;


}