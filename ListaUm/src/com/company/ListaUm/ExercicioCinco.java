package com.company.ListaUm;

import java.util.Scanner;

public class ExercicioCinco {
    public static void main(String[] args) {
        float hNor, hCin, hCem, hRs;
        double salario;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Por favor, informe o valor da hora em R$, o num de horas trabalhadas normas," +
                "o numero de horas extras 50%" +
                "e o número de horas extras 100%.");
        hRs = scanner.nextFloat();
        hNor= scanner.nextFloat();
        hCin = scanner.nextFloat();
        hCem = scanner.nextFloat();

        salario = (hNor*hRs)+(hCin*hRs*1.5)+(hCem*hRs*2);
        System.out.println(salario);


    }
}
