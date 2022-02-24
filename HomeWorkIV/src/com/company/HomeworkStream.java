package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class HomeworkStream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        int j = 0;
        List<Salario> salario = new ArrayList<>();
        salario.add(new Salario(++j, 1000.0));
        salario.add(new Salario(++j, 2000.0));
        salario.add(new Salario(++j, 2100.0));
        salario.add(new Salario(++j, 5000.0));

//        //1- listar todas as pessoas
          lista.forEach(p->{
              System.out.println(p.getNome());
              System.out.println(p.getCargo());
          });

        //2- filtrar todas as pessoas com salario maior do que 5 mil
        List<Pessoa> pessoasComSalarioMaiorQ5000 = lista.stream()
                .filter(pessoa -> pessoa.getSalario()>5000)
                .collect(Collectors.toList());
        pessoasComSalarioMaiorQ5000.forEach(System.out::println);

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente

        lista.stream()
                .filter(pessoa -> pessoa.getCargo().contains("Desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //4- fazer a média salarial de todos
        System.out.println("Média: "+lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average().getAsDouble()
             );

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        System.out.printf("Alguém recebe mais que 20000? ");
        if ((lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 20000))) {
            System.out.println(" Sim");
        } else {
            System.out.println(" Não");
        };


        //6 - retornar uma lista de todos os ids das pessoas
        List<Integer> idsPessoas = lista.stream()
            .map(pessoa -> pessoa.getId())
            .collect(Collectors.toList());
        System.out.println(idsPessoas);


        //7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto

        List<Salario> listaSalario = salario.stream()
                .map(pessoa -> {
                    Salario obj = new Salario(pessoa.getIdS(),pessoa.getSalarioS());
                return obj;
                })
                .collect(Collectors.toList());
       listaSalario.forEach(System.out::println);

        //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores
        Map<Integer, String> collect = lista.stream()
            .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(collect);

        //9- com o mapa da questão 8, retornar o nome com o id=2
        System.out.println(collect.get(2));

    }


    static class Salario {
        private int idS;
        private Double salarioS;
        Salario(){
        }

        Salario(int id, Double salario) {
            this.salarioS = salario;
            this.idS = id;
        }

        public int getIdS() {
            return idS;
        }

        public void setIdS(int idS) {
            this.idS = idS;
        }

        public Double getSalarioS() {
            return salarioS;
        }

        public void setSalarioS(Double salarioS) {
            this.salarioS = salarioS;
        }

        @Override
        public String toString() {
            return "Salario{" +
                    "idS=" + idS +
                    ", salarioS=" + salarioS +
                    '}';
        }
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }


    }

}

