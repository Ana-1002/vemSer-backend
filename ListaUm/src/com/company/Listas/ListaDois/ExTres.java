package com.company.Listas.ListaDois;

import java.util.Scanner;

public class ExTres {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int cont=0, idade;
        String nomes, maisV="", maisP="";
        float altura=0f, peso=0f, mediaA=0f, maiorA=0f, mp=0f, mi=0f;

        System.out.println("Nome ou sair:");
        nomes= scanner.nextLine();

        while (!nomes.equalsIgnoreCase("Sair")){
            cont++;
            System.out.println("Altura:");
            altura=scanner.nextFloat();
            System.out.println("Peso:");
            peso=scanner.nextFloat();
            System.out.println("Idade:");
            idade= scanner.nextInt();
            scanner.nextLine();
            mediaA+=altura;
            if(cont==1){
                maiorA=altura;
                maisV=nomes;
                maisP=nomes;
                mp=peso;
                mi=idade;
            }
            else {
                if (altura>maiorA){
                    maiorA=altura;
                }
                if (idade>mi){
                    mi=idade;
                    maisV=nomes;
                }
                if (peso>mp){
                    mp=peso;
                    maisP=nomes;
                }
            }
            System.out.println("Nome ou sair:");
            nomes= scanner.nextLine();

        }
        if(cont!=0){
        System.out.println("Quantidade de jogadores = "            +cont);
        System.out.println("Atura do maior Jogador = "           +maiorA);
        System.out.println("Jogador mais velho = "                +maisV);
        System.out.println("Jogador mais pesado = "               +maisP);
        System.out.println("Média das alturas jogadores = "+ mediaA/cont);
        }
        else {
            System.out.println("Nenhum jogador cadastrado.");
        }

    }
}
