package com.company.HomeWork3;

import java.util.ArrayList;

public class Cliente {


    private String nome;
    private String cpf;

    private ArrayList<Contato> contatosCliente = new ArrayList<>();
    private ArrayList<Endereco> enderecosCliente = new ArrayList<>();

    public  Cliente(){

    }

    public Cliente(String nome, String cpf, Contato contato, Contato contato2,Endereco enderecos, Endereco enderecos2){
        this.nome=nome;
        this.cpf=cpf;
        this.contatosCliente.add(contato);
        this.enderecosCliente.add(enderecos);
        this.contatosCliente.add(contato2);
        this.enderecosCliente.add(enderecos2);
    }

    public void imprimirContatos(){
        for(int i=0; i<2; i++){
           if(contatosCliente.get(i)!=null){
            System.out.println("Contato "+(i+1)+":\n");
            contatosCliente.get(i).imprimirContato();}
        }
    }
    public void imprimirEnderecos(){
        for(int i=0; i<2; i++){
            if(contatosCliente.get(i)==null){
            System.out.println("Endereço "+(i+1)+": \n");
            enderecosCliente.get(i).imprimirEndereco();}
        }
    }
    public void imprimirCliente(){
        System.out.println(
                "Nome: "+nome+"\n"+
                "CPF:  "+cpf+"\n"
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatosCliente() {
        return contatosCliente;
    }

    public void setContatosCliente(ArrayList<Contato> contatosCliente) {
        this.contatosCliente = contatosCliente;
    }

    public ArrayList<Endereco> getEnderecosCliente() {
        return enderecosCliente;
    }

    public void setEnderecosCliente(ArrayList<Endereco> enderecosCliente) {
        this.enderecosCliente = enderecosCliente;
    }
}
