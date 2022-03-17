package com.vemser.PrimeiroProjetoSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data

public class Pessoa {
    private Integer idPessoa;
    @NotEmpty
    private String nome;
    @NotBlank @Past
    private LocalDate dataNascimento;
    @CPF
    private String cpf;
    @Email
    private String email;
}
