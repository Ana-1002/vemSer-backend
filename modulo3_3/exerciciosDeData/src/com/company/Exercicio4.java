package com.company;

import java.time.LocalDateTime;

public class Exercicio4 {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now().plusDays(15).plusHours(10);

        System.out.println("Data atual + 15 dias e 10 horas:");
        System.out.println("\n Dia da semana: \t" + now.getDayOfWeek()
                + "\n Dia do ano: \t " + now.getDayOfYear());
    }

}
