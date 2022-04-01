package com.vemser.PrimeiroProjetoSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.entity.GrupoEntity;
import com.vemser.PrimeiroProjetoSpring.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;


    public Optional<GrupoEntity> findGrupoById(Integer id){
        return grupoRepository.findById(id);

    }
}
