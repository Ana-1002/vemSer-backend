package com.dbc.exercicioAula2Kafka.repository;

import com.dbc.exercicioAula2Kafka.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.kafka.requestreply.AggregatingReplyingKafkaTemplate;

import java.util.List;


public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {

        @Override
        List<VeiculoEntity> findAll();

}
