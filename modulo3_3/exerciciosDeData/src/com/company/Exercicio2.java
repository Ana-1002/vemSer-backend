package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer aux=1;

        System.out.println("Digite a primeira data: ");
        String data1 = scanner.nextLine();
        System.out.println("Digite a segunda data: ");
        String data2 = scanner.nextLine();

        LocalDate data1Data = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate data2Data = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (data1Data.isBefore(data2Data)) {
            aux=-1;
        }
            System.out.println("\nDiferença de dias: " + ChronoUnit.DAYS.between(data2Data, data1Data)*aux
                    +"\nDiferença de meses: " + ChronoUnit.MONTHS.between(data2Data, data1Data)*aux
                    +"\nDiferença de anos: " + ChronoUnit.YEARS.between(data2Data, data1Data)*aux);
    }
}
