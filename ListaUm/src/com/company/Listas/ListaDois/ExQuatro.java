package com.company.Listas.ListaDois;

import java.util.Scanner;

public class ExQuatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = new int[3];
        int aux=0;

        for (int i=0; i<3; i++){
            num[i]=scanner.nextInt();
            scanner.nextLine();
            if (i>0){
                if (num[i]<num[(i-1)]){
                    aux=i;
                }
            }

        }
        System.out.println(aux+1);

    }
}
