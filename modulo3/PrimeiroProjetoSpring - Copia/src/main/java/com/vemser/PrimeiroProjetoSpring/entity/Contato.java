package com.vemser.PrimeiroProjetoSpring.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    private String nomeContato;
    private String numeroContato;
}
