package com.company.Exercicios;

import java.util.Scanner;
import java.util.Stack;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Integer aux;
        Stack<Integer> pilha = new Stack<>();

        for(int i=0;i<15;i++){
            aux=scanner.nextInt();
            scanner.nextLine();
            if(aux%2==0){
                pilha.add(aux);
            }
            else
                if (i!=0 && pilha.size()!=0){
                   pilha.pop();
                }
        }
        while(pilha.size()!=0){
            aux=pilha.pop();
            System.out.println(aux);
        }
        if(pilha.size()==0){
            System.out.println("Pilha vazia");
        }
        }

    }

