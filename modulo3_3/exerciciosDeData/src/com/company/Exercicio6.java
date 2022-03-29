package com.company;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Exercicio6 {
    public static void main(String[] args) {

        LocalDateTime dataDoShow = LocalDateTime.of(2024, 9, 14, 18, 30);

        Integer aux=1;

        ZoneId zoneId = ZoneId.of("UTC+01:00");
        ZonedDateTime zonedEuropa = ZonedDateTime.of(dataDoShow, zoneId);

        LocalDateTime nowBrasilData = LocalDateTime.now();
        ZoneId zoneIdBr = ZoneId.of("UTC-03:00");
        ZonedDateTime zonedBrasil = ZonedDateTime.of(nowBrasilData, zoneIdBr);

        if (zonedBrasil.isAfter(zonedEuropa)) {
            System.out.println("O show mais aguardado do século já acabou há: ");
            aux=-1;
        } else {
            System.out.println("Para o show mais aguardado do século faltam: ");
        }

        System.out.println("Dias: " + ChronoUnit.DAYS.between(zonedBrasil, zonedEuropa)*aux);
        System.out.println("Meses: " + ChronoUnit.MONTHS.between(zonedBrasil, zonedEuropa)*aux);
        System.out.println("Anos: " + ChronoUnit.YEARS.between(zonedBrasil, zonedEuropa)*aux);
        System.out.println("Horas: " + ChronoUnit.HOURS.between(zonedBrasil, zonedEuropa)*aux);
        System.out.println("Minutos: " + ChronoUnit.MINUTES.between(zonedBrasil, zonedEuropa)*aux);
        System.out.println("Segundos: " + ChronoUnit.SECONDS.between(zonedBrasil, zonedEuropa)*aux);

    }

}
