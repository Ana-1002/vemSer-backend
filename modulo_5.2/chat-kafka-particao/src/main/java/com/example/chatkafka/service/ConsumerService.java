package com.example.chatkafka.service;
import com.example.chatkafka.dto.ChatDto;
import com.example.chatkafka.entity.TopicsEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;
    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "ana",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"1"})})
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ChatDto chatDto= objectMapper.readValue(message, ChatDto.class);
        log.info(" {} [{}] (private): {}", chatDto.getDataCriacao(), chatDto.getUsuario(), chatDto.getMensagem());
    }


    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "ana",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})})

    public void consumeGeral(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        ChatDto chatDto= objectMapper.readValue(message, ChatDto.class);
        log.info(" {} [{}] : {}", chatDto.getDataCriacao(), chatDto.getUsuario(), chatDto.getMensagem());
    }

}
