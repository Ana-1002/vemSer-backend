package com.company.homeworkUm;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.println(
                "Numero da Conta: "+numeroConta+"\n"+
                "Agencia:         "+agencia+"\n"+
                "Saldo:           "+saldo+"\n"+
                "Cheque especial: "+chequeEspecial+"\n");
    }

    public boolean sacar(double valorSaque){
        boolean retorno=false;
        if(valorSaque>0){
            if (valorSaque<=retornarSaldoComQuequeEspecial()){
                saldo-=valorSaque;
                retorno=true;
            }
        }
        return retorno;
    }

    public boolean depositar(double valorDeposito){
        if (valorDeposito>0){
            saldo+=valorDeposito;
            return true;
        }
        else {
            return false;
        }
    }

    public double retornarSaldoComQuequeEspecial(){
        return saldo+chequeEspecial;
    }

    public boolean trasferir(ContaCorrente conta, double valorTransferir){
        boolean retorno=false;

        if(valorTransferir>0){
            if (valorTransferir <= retornarSaldoComQuequeEspecial()) {
                conta.saldo+=valorTransferir;
                saldo-=valorTransferir;
                retorno = true;
            }
        }
        return retorno;
    }



}

