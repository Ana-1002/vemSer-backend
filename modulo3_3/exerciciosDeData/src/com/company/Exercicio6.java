package com.company;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Exercicio6 {
    public static void main(String[] args) {

        LocalDateTime dataDoShow = LocalDateTime.of(2024, 9, 14, 18, 30);

        ZoneId zoneId = ZoneId.of("GMT+01:00");
        ZonedDateTime zonedEuropa = ZonedDateTime.of(dataDoShow, zoneId);

        LocalDateTime nowBrasilData = LocalDateTime.now();
        ZoneId zoneIdBr = ZoneId.of("UTC-03:00");
        ZonedDateTime zonedBrasil = ZonedDateTime.of(nowBrasilData, zoneIdBr);

        if (zonedBrasil.isAfter(zonedEuropa)) {
            System.out.println("O show mais aguardado do século já acabou há: ");
        } else {
            System.out.println("Para o show mais aguardado do século faltam: ");
        }

        Period period = Period.between(zonedBrasil.toLocalDate(),zonedEuropa.toLocalDate());
        long secondsSub = zonedEuropa.getOffset().getTotalSeconds() - zonedBrasil.getOffset().getTotalSeconds();
        Duration duration = Duration.between(nowBrasilData.minusSeconds(secondsSub).toLocalTime(), zonedEuropa.toLocalTime());
        long hour = duration.abs().toHours();
        long minutes = duration.abs().toMinutes()%60;
        long seconds = duration.abs().getSeconds()%60;


        System.out.println("Dias: " + period.getDays());
        System.out.println("Meses: " + period.getMonths());
        System.out.println("Anos: " + period.getYears());
        System.out.println("Horas: " + hour);
        System.out.println("Minutos: " + minutes);
        System.out.println("Segundos: " + seconds);

    }

}
