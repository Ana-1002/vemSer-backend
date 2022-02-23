package com.company.HomeWork3;

public class Cliente {


    private String nome;
    private String cpf;
    private Contato[] contatosCliente = new Contato[2];
    private Endereco[] enderecosCliente = new Endereco[2];

    public  Cliente(){

    }

    public Cliente(String nome, String cpf, Contato contato, Contato contato2,Endereco enderecos, Endereco enderecos2){
        this.nome=nome;
        this.cpf=cpf;
        this.contatosCliente[0]=contato;
        this.enderecosCliente[0]=enderecos;
        this.contatosCliente[1]=contato2;
        this.enderecosCliente[1]=enderecos2;
    }

    public void imprimirContatos(){
        for(int i=0; i<2; i++){
           if(contatosCliente[i]!=null){
            System.out.println("Contato "+(i+1)+":\n");
            contatosCliente[i].imprimirContato();}
        }
    }
    public void imprimirEnderecos(){
        for(int i=0; i<2; i++){
            if(contatosCliente[i]!=null){
            System.out.println("Endereço "+(i+1)+": \n");
            enderecosCliente[i].imprimirEndereco();}
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

    public Contato[] getContatosCliente() {
        return contatosCliente;
    }

    public void setContatosCliente(Contato[] contatosCliente) {
        this.contatosCliente = contatosCliente;
    }

    public Endereco[] getEnderecosCliente() {
        return enderecosCliente;
    }

    public void setEnderecosCliente(Endereco[] enderecosCliente) {
        this.enderecosCliente = enderecosCliente;
    }
}
