package com.company.HomeWork3;


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
        Cliente cliente1= new Cliente();
        Cliente cliente2= new Cliente();

        cliente1.setNome("ana");
        cliente1.setCpf("51356541");
        cliente1.setEnderecosCliente(new Endereco[]{endereco2,endereco});
        cliente1.setContatosCliente(new Contato[]{contato2, contato1});

        cliente2.setNome("Maicon");
        cliente2.setCpf("51655");
        cliente2.setContatosCliente(new Contato[]{contato1,contato2});
        cliente2.setEnderecosCliente(new Endereco[]{endereco, endereco2});

        //metodos cliente
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();

        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();

        //Contas
        ContaCorrente contaAna= new ContaCorrente();
        ContaPoupança contaMaicon= new ContaPoupança();

        contaAna.setCliente(cliente1);
        contaAna.setNumeroConta("31635");
        contaAna.setAgencia(365);
        contaAna.setSaldo(2000);
        contaAna.setChequeEspecial(21);

        contaMaicon.setCliente(cliente2);
        contaMaicon.setNumeroConta("31635");
        contaMaicon.setAgencia(365);
        contaMaicon.setSaldo(1000);

        //metodos contas
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


    }
}
