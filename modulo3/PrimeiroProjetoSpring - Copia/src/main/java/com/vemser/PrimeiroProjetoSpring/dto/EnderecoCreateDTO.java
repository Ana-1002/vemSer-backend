package com.vemser.PrimeiroProjetoSpring.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class EnderecoCreateDTO {
    @NotEmpty
    private String tipo;
    @NotEmpty
    @Max(8)
    private String cep;
    @NotBlank
    private String numeroCasa;
    @NotEmpty
    @Max(250)
    private String logradouro;
    @NotEmpty @Max(250)
    private String cidade;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String pais;
}
