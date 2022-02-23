package com.company.Exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , String > tabela = new HashMap<>();
        tabela.put("123-123-123-10","Ana");
        tabela.put("123-123-123-14","Augusto");
        tabela.put("123-123-123-11","Maicon");
        tabela.put("123-123-123-13","Eduarda");
        tabela.put("123-123-123-12","Nicolas");
        tabela.put("123-123-123-15","Liane");

        String cpf= scanner.nextLine();
        if (tabela.get(cpf)!=null){
            System.out.println(tabela.remove(cpf));

        }else {
            System.out.println("CPF não encontrado");
        }
        System.out.println(tabela);


    }

}
