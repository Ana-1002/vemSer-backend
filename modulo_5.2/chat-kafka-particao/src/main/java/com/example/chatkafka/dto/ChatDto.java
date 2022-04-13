package com.example.chatkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatDto extends ChatCreateDto{
    private LocalDateTime dataCriacao;
    private String usuario;
}
