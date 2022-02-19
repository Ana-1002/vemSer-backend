package com.company.homeworkUm;

public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatosCliente = new Contato[2];
    public Endereco[] enderecosCliente = new Endereco[2];

    public void imprimirContatos(){
        for(int i=0; i<2; i++){
            System.out.println("Contato "+(i+1)+":\n");
            contatosCliente[i].imprimirContato();
        }
    }
    public void imprimirEnderecos(){
        for(int i=0; i<2; i++){
            System.out.println("Endereço "+(i+1)+": \n");
            enderecosCliente[i].imprimirEndereco();
        }
    }
    public void imprimirCliente(){
        System.out.println(
                "Nome: "+nome+"\n"+
                "CPF:  "+cpf+"\n"
        );
    }

}
