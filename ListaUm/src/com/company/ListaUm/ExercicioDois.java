package com.company.ListaUm;

import java.util.Scanner;

public class ExercicioDois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float nota;

        System.out.println("Por favor, digite suas 4 notas:");

        nota = scanner.nextFloat();
        nota += scanner.nextFloat();
        nota += scanner.nextFloat();
        nota += scanner.nextFloat();

        nota/= 4;

        System.out.println(nota);
        if(nota<0||nota>10){
            System.out.println("Nota inválida!");
        } else
        if (nota<=5){
            System.out.println("Reprovado T-T");
        } else
            if (nota<7){
                System.out.println("Em exame... o.O");
            }
            else
                if (nota>=7){
                    System.out.println("Aprovado! :D");
                }
    scanner.close();
    }
}
