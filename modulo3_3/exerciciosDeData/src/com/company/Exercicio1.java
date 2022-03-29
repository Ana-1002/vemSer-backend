package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe sua data de nascimento no formato dd/MM/yyyy por favor:\n");
        String dataNascUser = scanner.nextLine();

        Period periodo;

        LocalDate dataNascFormatada = LocalDate.parse(dataNascUser, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());

        System.out.println(dataNascFormatada);

        LocalDate hojeData = LocalDate.now();

        System.out.println(hojeData);

        if (hojeData.isBefore(dataNascFormatada)){
            periodo = Period.between(hojeData, dataNascFormatada);
            System.out.println("\n Faltam "+ periodo.getDays()+ " dias e" +periodo.getMonths()+" meses para o seu aniversário");
        }
        else
        {
            if(hojeData.equals(dataNascFormatada)){
                System.out.println("\nFeliz Aniversário!");
            }
            else
            if(hojeData.isAfter(dataNascFormatada)){
                Period period2 = Period.between(dataNascFormatada, hojeData);
                periodo = Period.between(hojeData, dataNascFormatada.plusYears(1));

                System.out.println("\n Passaram-se: \t "+ period2.getDays()+ " dias e " +period2.getMonths()+
                        " meses do seu aniversário desse ano \n Parabéns atrasado!\n Faltam "+ periodo.getDays()+ " dias e " +periodo.getMonths()+" meses para o seu próximo aniversário.");
            }
        }

    }
}
