package com.company.Listas.ListaDois;

import java.util.Scanner;

public class ExCinco {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int x =20;
        int[] vet = new int[x];

        for (int i=0; i<x; i++){
            vet[i]= scanner.nextInt();
            scanner.nextLine();
        }
        for (int j=(x-1); j>=0; j--){
            System.out.println(vet[j]);
        }
    }
}
