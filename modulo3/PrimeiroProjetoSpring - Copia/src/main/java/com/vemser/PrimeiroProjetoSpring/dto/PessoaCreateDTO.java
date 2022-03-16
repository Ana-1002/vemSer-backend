package com.vemser.PrimeiroProjetoSpring.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @NotEmpty
    private String nome;
    private LocalDate dataNascimento;
    @CPF
    private String cpf;
}
