package com.seguro.residencial.domain.models.root.cotacoes;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @criado 16/09/2020 - 00:35
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "cotacaoQuery")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CotacaoQuery {

    @Id
    @EqualsAndHashCode.Include
    private Long id;


    @NotNull(message = "The field 'title' is mandatory")
    @Column(nullable = false)
    private String titulo;

    public CotacaoQuery() {
    }
}
