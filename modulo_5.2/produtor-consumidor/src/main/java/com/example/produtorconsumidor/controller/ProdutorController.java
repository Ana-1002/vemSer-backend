package com.example.produtorconsumidor.controller;


import com.example.produtorconsumidor.service.ProdutorService;
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
    private void enviarMensagem(String mensagem) {
        produtorService.enviarMensagem(mensagem);
    }
}

