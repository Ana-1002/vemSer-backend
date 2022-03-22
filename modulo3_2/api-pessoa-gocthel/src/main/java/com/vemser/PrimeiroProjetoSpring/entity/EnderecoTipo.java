package com.vemser.PrimeiroProjetoSpring.entity;

import java.util.Arrays;

public enum EnderecoTipo {
    RESIDENTIAL(0),
    BUSINESS(1);

    private Integer type;

    EnderecoTipo(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static EnderecoTipo ofType(Integer type) {
        return Arrays.stream(EnderecoTipo.values())
                .filter(tp -> tp.getType().equals(type))
                .findFirst()
                .get();
    }
}
