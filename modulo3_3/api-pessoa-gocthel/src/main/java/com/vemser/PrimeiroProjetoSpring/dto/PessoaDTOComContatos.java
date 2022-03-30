package com.vemser.PrimeiroProjetoSpring.dto;


import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOComContatos extends PessoaDTO {
    private List<ContatoDTO> contatos;
}

