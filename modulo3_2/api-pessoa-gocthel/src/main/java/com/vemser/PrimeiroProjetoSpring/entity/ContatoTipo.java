package com.vemser.PrimeiroProjetoSpring.entity;

import java.util.Arrays;

public enum ContatoTipo {
    RESIDENTIAL(0),
    BUSINESS(1);

    private Integer type;

    ContatoTipo(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static ContatoTipo ofType(Integer type) {
        return Arrays.stream(ContatoTipo.values())
                .filter(tp -> tp.getType().equals(type))
                .findFirst()
                .get();
    }
}
