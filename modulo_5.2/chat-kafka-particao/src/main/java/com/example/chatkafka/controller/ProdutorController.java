package com.example.chatkafka.controller;


import com.example.chatkafka.dto.ChatCreateDto;
import com.example.chatkafka.entity.ChatEntity;
import com.example.chatkafka.entity.TopicsEnum;
import com.example.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviarMensagem")
    public void enviarMensagem(ChatCreateDto mensagem, TopicsEnum[] enums) throws JsonProcessingException {
        for(TopicsEnum topicsEnum:enums){
        produtorService.enviarMensagem(mensagem, topicsEnum.ordinal());}
    }
}

