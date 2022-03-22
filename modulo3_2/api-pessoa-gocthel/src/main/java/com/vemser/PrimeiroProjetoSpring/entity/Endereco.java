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
public class Endereco {
        private Integer idEndereco;
        private Integer idPessoa;
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
