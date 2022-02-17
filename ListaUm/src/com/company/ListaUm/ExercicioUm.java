package com.company.ListaUm;

import java.util.Scanner;

public class ExercicioUm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Por favor, digite sua idade em números inteiros:");
        int idade = scanner.nextInt();
        scanner= new Scanner(System.in);
        System.out.println("Por favor, digite sua cidade:");
        String cidade = scanner.nextLine();
        System.out.println("Por favor, digite seu estado:");
        String estado = scanner.nextLine();

        System.out.println("Seu nome é "+nome+", você tem "+idade+" anos, é da cidade de "+cidade+", situada no estado de "+estado+".");
        scanner.close();
    }
}
