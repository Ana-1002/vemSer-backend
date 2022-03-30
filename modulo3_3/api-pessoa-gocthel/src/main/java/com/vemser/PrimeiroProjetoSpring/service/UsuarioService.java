package com.vemser.PrimeiroProjetoSpring.service;

import com.vemser.PrimeiroProjetoSpring.entity.UsuarioEntity;
import com.vemser.PrimeiroProjetoSpring.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }
}
