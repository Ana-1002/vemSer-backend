package com.vemser.PrimeiroProjetoSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.LoginCreateDTO;
import com.vemser.PrimeiroProjetoSpring.entity.GrupoEntity;
import com.vemser.PrimeiroProjetoSpring.entity.UsuarioEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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

    public void createUser(LoginCreateDTO loginCreateDTO) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity= objectMapper.convertValue(loginCreateDTO,UsuarioEntity.class);
        String senha = new BCryptPasswordEncoder().encode(loginCreateDTO.getSenha());
        usuarioEntity.setSenha(senha);
        Set<GrupoEntity> grupos = new HashSet<>();
       for( Integer id: loginCreateDTO.getLista()){
           GrupoEntity grupoEntity = grupoService.findGrupoById(id);
           grupos.add(grupoEntity);
       }
       usuarioEntity.setGrupos(grupos);
        usuarioRepository.save(usuarioEntity);
    }

}
