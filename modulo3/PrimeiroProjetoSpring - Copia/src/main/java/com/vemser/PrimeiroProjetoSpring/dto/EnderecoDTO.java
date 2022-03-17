package com.vemser.PrimeiroProjetoSpring.dto;

import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO{
    private Integer idEndereco;
    private Integer idPessoa;
}
