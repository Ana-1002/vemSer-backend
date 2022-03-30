package com.vemser.PrimeiroProjetoSpring.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity(name= "ENDERECO_PESSOA")
public class EnderecoEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
        @SequenceGenerator(name= "ENDERECO_SEQ", sequenceName = "SEQ_ENDERECO_CONTATO", allocationSize = 1)
        @Column(name = "idEndereco")
        private Integer idEndereco;
        @Column(name = "tipo")
        @Enumerated(EnumType.ORDINAL)
        private EnderecoTipo tipo;
        @Column(name = "cep")
        private String cep;
        @Column(name = "numero")
        private Integer numero;
        @Column(name = "logradouro")
        private String logradouro;
        @Column(name = "cidade")
        private String cidade;
        @Column(name = "estado")
        private String estado;
        @Column(name = "pais")
        private String pais;
        @Column(name = "complemento")
        private String complemento;

        @JsonIgnore
        @ManyToMany(mappedBy = "enderecos")
        private Set<PessoaEntity> pessoas;
}
