package com.vemser.PrimeiroProjetoSpring.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOComEnderecos {
    private Integer idPessoa;
    private List<EnderecoDTO> enderecos;
}
