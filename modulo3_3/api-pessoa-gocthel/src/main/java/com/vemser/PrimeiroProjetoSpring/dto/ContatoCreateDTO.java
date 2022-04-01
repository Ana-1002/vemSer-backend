package com.vemser.PrimeiroProjetoSpring.dto;

import com.vemser.PrimeiroProjetoSpring.entity.ContatoTipo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty
    @Size(min = 9, max = 11)
    private String numero;

    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty
    @Size(max = 255)
    private String descricao;

}
