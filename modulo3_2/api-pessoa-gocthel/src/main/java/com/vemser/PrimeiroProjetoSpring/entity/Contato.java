package com.vemser.PrimeiroProjetoSpring.entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotEmpty @NotNull
    private String nomeContato;
    @NotEmpty @NotNull @Max(13)
    private String numeroContato;
}
