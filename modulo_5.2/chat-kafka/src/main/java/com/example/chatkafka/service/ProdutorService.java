package com.example.chatkafka.service;

import com.example.chatkafka.dto.ChatCreateDto;
import com.example.chatkafka.dto.ChatDto;
import com.example.chatkafka.entity.ChatEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String,String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topicoPrivate;

    public void enviarMensagem(ChatCreateDto chatCreateDto, String topico) throws JsonProcessingException {
        ChatDto chatDto= objectMapper.convertValue(chatCreateDto,ChatDto.class);
        chatDto.setDataCriacao(LocalDateTime.now());
        chatDto.setUsuario("Ana Vitoria");
        String chat = objectMapper.writeValueAsString(chatDto);
        Message<String> message = MessageBuilder.withPayload(chat)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", message);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", message, ex);
            }
        });
    }
}
