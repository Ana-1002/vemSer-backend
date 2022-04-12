package com.dbc.exercicioAula2Kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("veiculo")
public class VeiculoEntity {
    @Id
    private String id;
    private LocalDateTime dataLeitura;
    private  Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}
