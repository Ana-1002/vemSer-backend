package com.company.HomeWork3;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //contatos
        Contato contato1= new Contato("Meu número 1", "516525", 1);
        Contato contato2=new Contato("Meu número 2", "516525", 1);

        //metodos contatos
        contato2.imprimirContato();
        contato1.imprimirContato();

        //enderecos
        Endereco endereco= new Endereco();
        endereco.setEstado("rs");
        endereco.setCidade("butia");
        endereco.setCep("51");
        endereco.setTipoEnd(1);
        endereco.setComplemento("jiu");
        endereco.setNumero(2);
        endereco.setPais("coreia");
        endereco.setLogradouro("Rua pedro martinez");

        Endereco endereco2= new Endereco();
        endereco2.setEstado("pd");
        endereco2.setCidade("sj");
        endereco2.setCep("515365");
        endereco2.setTipoEnd(2);
        endereco2.setComplemento("shnksnlsh");
        endereco2.setNumero(5);
        endereco2.setPais("coreia");
        endereco2.setLogradouro("Centro");

        //metodos enderecos
        endereco.imprimirEndereco();
        endereco2.imprimirEndereco();

        //Cientes
        Cliente cliente1= new Cliente("Ana", "043896532525", contato1, null, endereco, endereco2);
        Cliente cliente2= new Cliente("Maicon", "123-123-123-50", contato2, contato1, endereco2, null);


        //metodos cliente
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();

        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();

        //Contas
        ContaCorrente contaAna =new ContaCorrente();
        ContaPagamento contaPagamentoAna=new ContaPagamento();
        ContaPoupança contaMaicon= new ContaPoupança();

        contaAna.setCliente(cliente1);
        contaAna.setNumeroConta("31635");
        contaAna.setAgencia(365);
        contaAna.setSaldo(2000);
        contaAna.setChequeEspecial(21);

        contaPagamentoAna.setCliente(cliente1);
        contaPagamentoAna.setNumeroConta("2020-2");
        contaPagamentoAna.setAgencia(365);
        contaPagamentoAna.setSaldo(2000);


        contaMaicon.setCliente(cliente2);
        contaMaicon.setNumeroConta("31635");
        contaMaicon.setAgencia(365);
        contaMaicon.setSaldo(1000);

        System.out.println("Conta Pagamento Ana\n");
        contaPagamentoAna.imprimir();
        contaPagamentoAna.sacar(1000);
        contaPagamentoAna.depositar(-5);
        System.out.println("Valor Saldo conta Pagamento Ana: "+contaPagamentoAna.getSaldo()+"\n");

        contaPagamentoAna.depositar(2000);
        System.out.println("Valor Saldo conta Pagamento Ana: "+contaPagamentoAna.getSaldo()+"\n");

        System.out.println("Valor Transferido de Maicon para conta Pagamento da Ana? "+contaMaicon.transferir(contaPagamentoAna,1000)+"\n");
        System.out.println("Valor Saldo Maicon: "+contaMaicon.getSaldo()+"\n");
        System.out.println("Valor Saldo da conta Pagamento Ana: "+contaPagamentoAna.getSaldo()+"\n");

        System.out.println("Valor Transferido de conta Pagamento da Ana para conta Corrente da Ana? "+contaPagamentoAna.transferir(contaAna,1000)+"\n");
        System.out.println("Valor Saldo e Cheque especial da Ana conta Corrente: "+contaAna.retornarSaldoComQuequeEspecial()+"\n");
        System.out.println("Valor Saldo da conta Pagamento Ana: "+contaPagamentoAna.getSaldo()+"\n");


        /*metodos contas
        System.out.println("Conta Ana\n");
        contaAna.imprimir();
        contaAna.sacar(2000);
        contaAna.depositar(-5);
        System.out.println("Valor Saldo e Cheque especial Ana: "+contaAna.retornarSaldoComQuequeEspecial()+"\n");

        System.out.println("Conta Maicon\n");
        contaMaicon.imprimir();
        contaMaicon.sacar(-100);
        contaMaicon.depositar(2000);
        System.out.println("Valor Saldo  Maicon: "+contaMaicon.getSaldo()+"\n");
        contaMaicon.creditarTaxa();
        System.out.println("Valor Saldo  Maicon: "+contaMaicon.getSaldo()+"\n");


        System.out.println("Valor Transferido? "+contaMaicon.transferir(contaAna,1000)+"\n");
        System.out.println("Valor Saldo e Cheque especial Maicon: "+contaMaicon.getSaldo()+"\n");
        System.out.println("Valor Saldo e Cheque especial Ana: "+contaAna.retornarSaldoComQuequeEspecial()+"\n");

       */


    }
}
