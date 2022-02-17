package com.company.ListaUm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExercicioTres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o valor total consumido e o valor pago pelo cliente.");
        float valC = scanner.nextFloat();
        float valP = scanner.nextFloat();

        if (valP!=valC) {
            if (valP < valC) {
                System.out.println("“o valor pago " +
                        "deve ser maior ou igual ao valor consumido");
            } else if (valP > valC) {
                float troco = valP - valC;
                System.out.println(troco);
            }
        }
    scanner.close();
    }
}
