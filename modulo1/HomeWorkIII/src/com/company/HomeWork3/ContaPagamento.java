package com.company.HomeWork3;

public class ContaPagamento extends Conta implements Impressao {
    private static double TAXA_SAQUE =4.25;

    public void imprimir(){
        System.out.println(
                "Numero da Conta: "+getNumeroConta()+"\n"+
                        "Agencia:         "+getAgencia()+"\n"+
                        "Saldo:           "+getSaldo()+"\n");
        System.out.println(TAXA_SAQUE);
    }
    @Override
    public boolean sacar(double valorSaque){
        boolean retorno = false;
        if (valorSaque > 0) {
            if (valorSaque+TAXA_SAQUE <= getSaldo()) {
                super.setSaldo(getSaldo() - (valorSaque+TAXA_SAQUE));
                retorno = true;
            }
        }
        return retorno;
    }
    @Override
    public String toString() {
        return "ContaPagamento{}"+ "\n Taxa Saque: R$"+TAXA_SAQUE;
    }
}
