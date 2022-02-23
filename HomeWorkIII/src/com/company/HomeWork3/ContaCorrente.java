package com.company.HomeWork3;

public class ContaCorrente extends Conta implements Impressao{

    private double chequeEspecial;

    public double retornarSaldoComQuequeEspecial () {

        double var= getSaldo();
        return (var+chequeEspecial);
    }


    public double getChequeEspecial() {
        return chequeEspecial;
    }


    public void setChequeEspecial(double cheque) {

        this.chequeEspecial = cheque;
    }

    public void imprimir(){
        System.out.println(
                "Numero da Conta: "+getNumeroConta()+"\n"+
                        "Agencia:         "+getAgencia()+"\n"+
                        "Saldo:           "+getSaldo()+"\n");
        System.out.println("Cheque especial: "+chequeEspecial);
    }
}
