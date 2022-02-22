package com.company;

public class Contato {

        private String descricao;
        private String telefone;
        //tipo: (1-residencial 2-comercial)
        private int tipoCont;

        public Contato(String descricao, String telefone, int tipoCont){
            this.descricao=descricao;
            this.telefone=telefone;
            this.tipoCont=tipoCont;
        }

        public void imprimirContato(){
            System.out.println("Descrição: "+descricao+"\n"+
                    "Telefone:  "+telefone+"\n"+
                    "Tipo:     "+tipoCont+"\n");
        }

    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getTipoCont() {
        return tipoCont;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipoCont(int tipoCont) {
        this.tipoCont = tipoCont;
    }
}
