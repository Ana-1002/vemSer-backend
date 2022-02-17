package com.company.ListaUm;

import java.util.Locale;
import java.util.Scanner;

public class ExercicioSeis {
    public static void main(String[] args) {
        String palavra, traducao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite uma palavra para traduzirmos");
        palavra = scanner.nextLine();
        palavra= palavra.toLowerCase();

        switch (palavra){
            case "dog":
                traducao    =  "cachorro";
                break;
            case "cachorro" :
                traducao    =   "dog";
                break;
            case  "tempo":
                traducao    =   "time";
                break;
            case "amor":
                traducao    =   "love";
                break;
            case "cidade":
                traducao    =   "city";
                break;
            case "feliz":
                traducao    =   "happy";
                break;
            case "time":
                traducao    =   "tempo";
                break;
            case "love":
                traducao    =   "amor";
                break;
            case "city":
                traducao    =   "cidade";
                break;
            case "happy"  :
                traducao    =   "feliz";
                break;
            default:
                traducao    =   "Essa " +
                        "palavra não é válida.";

        }
        System.out.println(traducao);
    }
}
