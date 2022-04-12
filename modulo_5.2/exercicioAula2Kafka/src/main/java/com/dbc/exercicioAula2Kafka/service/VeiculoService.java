package com.dbc.exercicioAula2Kafka.service;

import com.dbc.exercicioAula2Kafka.dto.VeiculoDTO;
import com.dbc.exercicioAula2Kafka.entity.VeiculoEntity;
import com.dbc.exercicioAula2Kafka.repository.VeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ObjectMapper objectMapper;

    public VeiculoDTO save(VeiculoDTO veiculoDTO){
        veiculoRepository.save(objectMapper.convertValue(veiculoDTO, VeiculoEntity.class));
        return veiculoDTO;
    }

    public Integer retornaNumTotalLeituras(){
        Set<VeiculoDTO> listaVeiculo = findAll();
        return listaVeiculo.size();
    }
    public Set<VeiculoDTO> findAll(){
        return veiculoRepository.findAll().stream()
                .map(veiculoEntity -> objectMapper.convertValue(veiculoEntity,VeiculoDTO.class))
                .collect(Collectors.toSet());
    }

    public Double mediaVelocidade(){
        Set<VeiculoDTO> veiculoDTOS=findAll();
        Double valor= Double.valueOf(0);
        for (VeiculoDTO var: veiculoDTOS){
            valor+=var.getVelocidade();
        }
       return valor/veiculoDTOS.size();
    }
    public Double mediaRotacao(){
        Set<VeiculoDTO> veiculoDTOS=findAll();
        Double valor= Double.valueOf(0);
        for (VeiculoDTO var: veiculoDTOS){
            valor+=var.getRotacao();
        }
        return valor/veiculoDTOS.size();
    }
}
