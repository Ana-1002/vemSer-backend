package com.vemser.PrimeiroProjetoSpring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LoginCreateDTO {
    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private List<Integer> lista;
}
