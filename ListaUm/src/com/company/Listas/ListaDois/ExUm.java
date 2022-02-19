package com.company.Listas.ListaDois;

import java.util.Scanner;

public class ExUm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float  valorP;
        float desconto;
        String nomeP;

        System.out.println("Digite o nome do produto:");
        nomeP = scanner.nextLine();
        System.out.println("Digite o valor do produto:");
        valorP = scanner.nextFloat();
        scanner.nextLine();

        System.out.println(valorP);
        desconto=valorP*0.05f;
        System.out.println("Promoção: "+ nomeP);

        for (int i=1; i<=10; i++){
            valorP-=desconto;
            System.out.printf("%d x R$ %.2f = %.2f \n",i,(valorP),(i*valorP));
        }
    }
}
