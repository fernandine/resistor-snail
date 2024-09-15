package com.api_challenge.resistor.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ColorCode {
    PRETO(0, "preto"),
    MARROM(1, "marrom"),
    VERMELHO(2, "vermelho"),
    LARANJA(3, "laranja"),
    AMARELO(4, "amarelo"),
    VERDE(5, "verde"),
    AZUL(6, "azul"),
    VIOLETA(7, "violeta"),
    CINZA(8, "cinza"),
    BRANCO(9, "branco"),
    DOURADO(-1, "dourado");

    private final int value;
    private final String color;

    public static ColorCode fromValue(int value) {
        for (ColorCode code : ColorCode.values()) {
            if (code.getValue() == value) {
                return code;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}

