package com.company.homeworkUm;

public class Endereco {
    public int tipoEnd;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco(){
        System.out.println(
                        "Endereço:    "+tipoEnd+"\n"+
                        "Número:      "+numero+"\n"+
                        "Complemento: "+complemento+"\n"+
                         "Cep:        "+cep+"\n"+
                         "Cidade:     "+cidade+"\n"+
                         "Estado:     "+estado+"\n"+
                         "País:       "+pais+"\n"
        );
    }
}
