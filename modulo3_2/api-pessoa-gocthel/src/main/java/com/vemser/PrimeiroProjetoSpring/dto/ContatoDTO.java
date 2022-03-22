package com.vemser.PrimeiroProjetoSpring.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;
    private Integer idPessoa;
}
