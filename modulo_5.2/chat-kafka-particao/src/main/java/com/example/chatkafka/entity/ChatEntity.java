package com.example.chatkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatEntity {
    private LocalDateTime dataCriacao;
    private String usuario;
    private String mensagem;
}
