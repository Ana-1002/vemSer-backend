package com.company.Exercicios;

import java.util.ArrayList;
import java.util.Comparator;

public class ex6 {
    public static void main(String[] args) {
    ArrayList<Pessoa> pessoa = new ArrayList<>();

    pessoa.add(new Pessoa("Ana", 40));
    pessoa.add(new Pessoa("Liane", 50));
    pessoa.add(new Pessoa("Ana", 52));
    pessoa.add(new Pessoa("Nicolas", 19));
    pessoa.add(new Pessoa("Duda", 7));
    pessoa.add(new Pessoa("Maria", 12));
    pessoa.add(new Pessoa("Maicon", 30));

        System.out.println(pessoa);
             pessoa.sort(new Comparator<Pessoa>(){
                  public int compare(Pessoa o1, Pessoa o2){
                      return  o1.getIdade() - o2.getIdade();
                  }
             });

        System.out.println(pessoa);
            pessoa.sort(new Comparator<Pessoa>(){
                public int compare(Pessoa o1, Pessoa o2){
                    return  o1.getNome().compareTo(o2.getNome());
           }
       });

       System.out.println(pessoa);
            pessoa.sort(new Comparator<Pessoa>(){
                public int compare(Pessoa o1, Pessoa o2){
                    if(o1.getNome().compareTo(o2.getNome()) != 0){
                        return  o1.getNome().compareTo(o2.getNome());
                    } else {
                    return  o2.getIdade() - o1.getIdade();}
                }
            });

        System.out.println(pessoa);
    }

}
