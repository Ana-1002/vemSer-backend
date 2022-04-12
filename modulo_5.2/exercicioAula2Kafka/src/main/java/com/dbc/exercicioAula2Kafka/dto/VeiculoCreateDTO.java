package com.dbc.exercicioAula2Kafka.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoCreateDTO {
    private Double velocidade;
    private Integer rotacao;
    private Boolean sensorFrenagem;
}
