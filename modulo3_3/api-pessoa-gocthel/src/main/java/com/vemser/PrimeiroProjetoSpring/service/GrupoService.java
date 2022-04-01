package com.vemser.PrimeiroProjetoSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.entity.GrupoEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;


    public GrupoEntity findGrupoById(Integer id) throws RegraDeNegocioException {
        return grupoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Grupo não encontrado"));

    }
}
