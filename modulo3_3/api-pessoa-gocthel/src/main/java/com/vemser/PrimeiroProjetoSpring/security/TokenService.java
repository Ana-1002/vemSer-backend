package com.vemser.PrimeiroProjetoSpring.security;

import com.vemser.PrimeiroProjetoSpring.entity.UsuarioEntity;
import com.vemser.PrimeiroProjetoSpring.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private static final String CARACTER_SEPARACAO = ";";
    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity){
        String tokenTexto = usuarioEntity.getLogin() + CARACTER_SEPARACAO + usuarioEntity.getSenha(); // user;password
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes()); //
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token){
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedTokenBytes = Base64.getUrlDecoder().decode(token);
        String decodedTokenString = new String(decodedTokenBytes); //user;password
        String[] usuarioESenha = decodedTokenString.split(CARACTER_SEPARACAO);/// ['user', 'password']
        return usuarioService.findByLoginAndSenha(usuarioESenha[0] /*user*/, usuarioESenha[1] /*password*/);
    }
}
