package com.company;

public class ContaPoupança extends Conta implements Impressao{
   private final static double JUROS_MENSAL=1.01;

   public void creditarTaxa(){
      setSaldo(getSaldo()*JUROS_MENSAL);
   }

   public void imprimir(){
         System.out.println(
                 "Numero da Conta: "+getNumeroConta()+"\n"+
                         "Agencia:         "+getAgencia()+"\n"+
                         "Saldo:           "+getSaldo()+"\n");
   }

   @Override
   public String toString() {
      return "ContaPoupança{} " + super.toString();
   }

}
