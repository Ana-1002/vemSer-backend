package com.company.HomeWork3;

public interface Movimentacao {
    public boolean sacar(double valorSaque);
    public boolean depositar(double valorDepositar);
    public boolean transferir(Conta conta, double valor);
}
