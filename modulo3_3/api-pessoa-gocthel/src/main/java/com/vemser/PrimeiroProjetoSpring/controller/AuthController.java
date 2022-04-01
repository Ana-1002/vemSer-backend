package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.dto.AuthDTO;
import com.vemser.PrimeiroProjetoSpring.dto.LoginCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.LoginDTO;
import com.vemser.PrimeiroProjetoSpring.security.TokenService;
import com.vemser.PrimeiroProjetoSpring.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    @PostMapping("/createUser")
    public void createUser(@RequestBody @Valid LoginCreateDTO loginCreateDTO) throws Exception {
       usuarioService.createUser(loginCreateDTO);
    }

    @PostMapping()
    public String auth(@RequestBody @Valid AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        authDTO.getLogin(),
                        authDTO.getSenha()
                );

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.getToken(authenticate);
        return token;
    }
    }

