package com.vemser.PrimeiroProjetoSpring.dto;

import com.vemser.PrimeiroProjetoSpring.entity.EnderecoTipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoDTO extends EnderecoCreateDTO{
    private Integer idEndereco;
    @ApiModelProperty(value = "Tipo de endereco")
    @NotNull
    @Max(2)
    private EnderecoTipo tipo;
}
