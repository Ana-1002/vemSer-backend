package com.vemser.PrimeiroProjetoSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.LoginCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.LoginDTO;
import com.vemser.PrimeiroProjetoSpring.entity.GrupoEntity;
import com.vemser.PrimeiroProjetoSpring.entity.UsuarioEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoService grupoService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }
    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public void createUser(LoginCreateDTO loginCreateDTO) {
        UsuarioEntity usuarioEntity= objectMapper.convertValue(loginCreateDTO,UsuarioEntity.class);
        String senha = new BCryptPasswordEncoder().encode(loginCreateDTO.getSenha());
        usuarioEntity.setSenha(senha);
        usuarioEntity.setGrupos(loginCreateDTO.getLista()
                .stream()
                .map(s-> {
                    Optional<GrupoEntity> optional = grupoService.findGrupoById(s);
                    if(optional.isPresent()){
                        return optional.get();
                    } return null;
                })
                .collect(Collectors.toSet()));
        usuarioRepository.save(usuarioEntity);
    }
}
