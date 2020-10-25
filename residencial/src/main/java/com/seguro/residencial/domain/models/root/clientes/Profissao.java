package com.seguro.residencial.domain.models.root.clientes;

import com.seguro.residencial.domain.models.root.cotacoes.CotacaoRoot;
import lombok.Data;

import javax.persistence.*;

/**
 * @criado 24/10/2020 - 21:06
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Data
@Entity
@Table(name = "profissao")
public class Profissao {
    @Id
    private Long id;

    @Column(nullable = false, length = 10)
    private String descricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente"
            , foreignKey = @ForeignKey(name = "fk_clienteProfissao"))
    private ClienteRoot cliente;
}
