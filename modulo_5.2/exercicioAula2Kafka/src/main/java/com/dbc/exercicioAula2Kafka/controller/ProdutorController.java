package com.dbc.exercicioAula2Kafka.controller;


import com.dbc.exercicioAula2Kafka.dto.VeiculoCreateDTO;
import com.dbc.exercicioAula2Kafka.dto.VeiculoDTO;
import com.dbc.exercicioAula2Kafka.service.ProdutorService;
import com.dbc.exercicioAula2Kafka.service.VeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;
    private final VeiculoService veiculoService;

    @PostMapping("/enviarMensagem")
    public void enviarMensagem(VeiculoCreateDTO mensagem) throws JsonProcessingException {
        produtorService.enviarMensagem(mensagem);
    }

    @GetMapping("/findAll")
    public Set<VeiculoDTO> findAll(){
       return veiculoService.findAll();
    }
    @GetMapping("/totalLeituras")
    public Integer dashBoard(){
        return veiculoService.retornaNumTotalLeituras();
    }
    @GetMapping("/mediaVelocidade")
    public Double mediaVelocidade(){
        return veiculoService.mediaVelocidade();
    }
    @GetMapping("/mediaRotacao")
    public Double mediaRotacao(){
        return veiculoService.mediaRotacao();
    }
}

