package com.company.Exercicios;

import java.util.LinkedList;
import java.util.Queue;

public class Ex3 {

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList();
        fila.add(1);
        fila.add(2);
        fila.add(3);
        fila.add(4);
        fila.add(5);
        System.out.println(fila);
        fila.poll();
        fila.poll();
        System.out.println(fila);
        fila.poll();
        System.out.println(fila);
        fila.add(6);
        fila.add(7);
        fila.add(8);
        System.out.println(fila);
        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println(fila);





    }
}
