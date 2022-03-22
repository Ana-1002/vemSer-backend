package com.vemser.PrimeiroProjetoSpring.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @ApiModelProperty(value = "ID pessoa")
    private Integer idPessoa;

    @ApiModelProperty(value = "Tipo de Contato")
    @NotNull
    @Max(2)
    private Integer tipo;

    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty
    @Size(min = 9, max = 11)
    private String numeroTelefone;

    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty
    @Size(max = 255)
    private String descricao;
//    private Integer idPessoa;
//
//    private Integer tipo;
//
//    private String numero;
//
//    private String descricao;
}
