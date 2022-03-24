package com.vemser.PrimeiroProjetoSpring.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOCompleto extends PessoaDTO{
    private List<EnderecoDTO> enderecos;
    private List<ContatoDTO> contatos;
}
