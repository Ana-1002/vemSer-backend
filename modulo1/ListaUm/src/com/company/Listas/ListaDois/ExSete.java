package com.company.Listas.ListaDois;

import java.util.Scanner;

public class ExSete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        int cont=0;

        for(int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                matriz[i][j] = scanner.nextInt();
                scanner.nextLine();
                if (matriz[i][j]>10){
                    cont++;
                }
            }
        }

        System.out.println("A matriz possui "+cont+" números maiores que 10.");
    }
}
