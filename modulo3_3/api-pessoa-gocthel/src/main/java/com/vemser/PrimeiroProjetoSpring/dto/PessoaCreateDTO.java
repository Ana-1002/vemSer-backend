package com.vemser.PrimeiroProjetoSpring.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @ApiModelProperty (value="Nome da pessoa")
    @NotEmpty
    private String nome;
    @ApiModelProperty (value="Data de nascimentp")
    private LocalDate dataNascimento;
    @ApiModelProperty (value="Cpf")
    @CPF
    private String cpf;
}
