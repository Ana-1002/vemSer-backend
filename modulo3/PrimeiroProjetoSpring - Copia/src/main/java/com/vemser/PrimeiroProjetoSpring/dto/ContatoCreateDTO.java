package com.vemser.PrimeiroProjetoSpring.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ContatoCreateDTO {
    @NotEmpty
    @NotNull
    private String nomeContato;
    @NotEmpty @NotNull @Max(13)
    private String numeroContato;
}
