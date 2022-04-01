package com.vemser.PrimeiroProjetoSpring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "GRUPO")
public class GrupoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupo")
    @SequenceGenerator(name = "seq_grupo", sequenceName = "seq_grupo", allocationSize = 1)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;

    @ManyToMany(mappedBy = "grupos")
    private List<UsuarioEntity> usuarios;

    @ManyToMany
    @JoinTable(
            name = "GRUPO_REGRA",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_regra")
    )
    private List<RegraEntity> regras;

}
