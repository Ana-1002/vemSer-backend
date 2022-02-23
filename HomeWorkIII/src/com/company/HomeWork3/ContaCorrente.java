package com.company.HomeWork3;

public class ContaCorrente extends Conta implements Impressao{

    private double chequeEspecial;

    public double retornarSaldoComQuequeEspecial () {

        double var= getSaldo();
        return (var+chequeEspecial);
    }
    @Override
    public boolean sacar(double valorSaque){
        boolean retorno = false;
        if (valorSaque > 0) {
            if (valorSaque <= retornarSaldoComQuequeEspecial()) {
                super.setSaldo(getSaldo() - valorSaque);
                retorno = true;
            }
        }
        return retorno;
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
