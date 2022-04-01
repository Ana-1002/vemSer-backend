package com.vemser.PrimeiroProjetoSpring.dto;

import com.vemser.PrimeiroProjetoSpring.entity.ContatoTipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;

    @ApiModelProperty(value = "Tipo de Contato")
    @NotNull
    @Max(2)
    private ContatoTipo tipo;


    private Integer idPessoa;
}
