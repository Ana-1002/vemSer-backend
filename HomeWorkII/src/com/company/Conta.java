package com.company;

public abstract class  Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;


        @Override
        public boolean sacar(double valorSaque){
                boolean retorno = false;
            if (valorSaque > 0) {
                if (valorSaque <= saldo) {
                    saldo -= valorSaque;
                    retorno = true;
                }
            }
            return retorno;
        }
        @Override
        public boolean depositar ( double valorDeposito){
            if (valorDeposito > 0) {
                saldo += valorDeposito;
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean transferir(Conta conta,double valor){
            boolean retorno = false;

            if (valor > 0) {
                if (valor <= saldo) {
                    conta.saldo += valor;
                    saldo -= valor;
                    retorno = true;
                }
            }
            return retorno;
        }

        public Cliente getCliente () {
            return cliente;
        }

        public void setCliente (Cliente cliente){
            this.cliente = cliente;
        }

        public String getNumeroConta () {
            return numeroConta;
        }

        public void setNumeroConta (String numeroConta){
            this.numeroConta = numeroConta;
        }

        public int getAgencia () {
            return agencia;
        }

        public void setAgencia ( int agencia){
            this.agencia = agencia;
        }

        public double getSaldo () {
            return saldo;
        }

        public void setSaldo ( double saldo){
            this.saldo = saldo;
        }

    }