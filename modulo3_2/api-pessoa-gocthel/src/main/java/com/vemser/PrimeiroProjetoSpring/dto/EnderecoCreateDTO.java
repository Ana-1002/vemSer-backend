package com.vemser.PrimeiroProjetoSpring.dto;

import com.vemser.PrimeiroProjetoSpring.entity.EnderecoTipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    @ApiModelProperty(value = "Tipo de endereco")
    @NotNull
    @Max(2)
    private EnderecoTipo tipo;

    @ApiModelProperty(value = "logradouro")
    @NotEmpty
    @Size(min = 1, max = 200)
    private String logradouro;

    @ApiModelProperty(value = "Numero")
    @NotNull
    private Integer numero;

    @ApiModelProperty(value = "complemento")
    @NotEmpty
    @Size(max = 200)
    private String complemento;

    @ApiModelProperty(value = "cep")
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @ApiModelProperty(value = "Cidade/Municipio")
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 250)
    private String cidade;

    @ApiModelProperty(value = "Estado")
    @NotNull
    private String estado;

    @ApiModelProperty(value = "Pais")
    @NotNull
    private String pais;
//    private Integer tipo;
//    private String cep;
//    private String complemento;
//    private Integer numero;
//
//    private String logradouro;
//
//    private String cidade;
//
//    private String estado;
//
//    private String pais;

}
