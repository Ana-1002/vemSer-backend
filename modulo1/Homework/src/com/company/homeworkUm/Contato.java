package com.company.homeworkUm;

public class Contato {

    public String descricao;
    public String telefone;
    //tipo: (1-residencial 2-comercial)
    public int tipoCont;

    public void imprimirContato(){
        System.out.println("Descrição: "+descricao+"\n"+
                           "Telefone:  "+telefone+"\n"+
                            "Tipo:     "+tipoCont+"\n");
    }


}
