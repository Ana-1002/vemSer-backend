package com.vemser.PrimeiroProjetoSpring.dto;

import com.vemser.PrimeiroProjetoSpring.entity.RegraEntity;
import com.vemser.PrimeiroProjetoSpring.entity.UsuarioEntity;
import lombok.Data;

import java.util.List;

@Data
public class GrupoDTO {

    private Integer idGrupo;

    private String nome;

    private String descricao;

    private List<UsuarioEntity> usuarios;

    private List<RegraEntity> regras;
}
