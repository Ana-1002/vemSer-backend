package com.company.homeworkUm;

public class Main {
    public static void main(String[] args) {
        Contato contato1= new Contato();
        Contato contato2=new Contato();

        //contatos
        contato1.descricao="Meu número 1";
        contato1.tipoCont=1;
        contato1.telefone="939303930";

        contato2.descricao="Meu número 2";
        contato2.tipoCont=2;
        contato2.telefone="526523131365";

            //metodos contatos
            contato2.imprimirContato();
            contato1.imprimirContato();

        //enderecos
        Endereco endereco= new Endereco();
        endereco.estado="RS";
        endereco.cidade="butia";
        endereco.cep="523251";
        endereco.tipoEnd=1;
        endereco.complemento="nada";
        endereco.numero=1;
        endereco.pais="Coreia";
        endereco.logradouro="Rua pedro martinez";

        Endereco endereco2= new Endereco();
        endereco2.estado="SC";
        endereco2.cidade="curitiba";
        endereco2.cep="4531";
        endereco2.tipoEnd=2;
        endereco2.complemento="nada";
        endereco2.numero=5;
        endereco2.pais="Coreia";
        endereco2.logradouro="Rua pedro martinez";

            //metodos enderecos
            endereco.imprimirEndereco();
            endereco2.imprimirEndereco();

        //Cientes
        Cliente cliente1= new Cliente();
        Cliente cliente2= new Cliente();

        cliente1.nome="ana";
        cliente1.cpf="51356541";
        cliente1.enderecosCliente[0]=endereco;
        cliente1.enderecosCliente[1]=endereco2;
        cliente1.contatosCliente[0]=contato1;
        cliente1.contatosCliente[1]=contato2;

        cliente2.nome="Maicon";
        cliente2.cpf="51356541";
        cliente2.enderecosCliente[0]=endereco;
        cliente2.enderecosCliente[1]=endereco2;
        cliente2.contatosCliente[0]=contato1;
        cliente2.contatosCliente[1]=contato2;


        //metodos cliente
            cliente1.imprimirCliente();
            cliente1.imprimirContatos();
            cliente1.imprimirEnderecos();

            cliente2.imprimirCliente();
            cliente2.imprimirContatos();
            cliente2.imprimirEnderecos();

        //Contas
        ContaCorrente contaAna= new ContaCorrente();
        ContaCorrente contaMaicon= new ContaCorrente();

        contaAna.cliente=cliente1;
        contaAna.numeroConta="1";
        contaAna.agencia=1;
        contaAna.saldo=5222.5;
        contaAna.chequeEspecial=1000;

        contaMaicon.cliente=cliente2;
        contaMaicon.numeroConta="2";
        contaMaicon.agencia=2;
        contaMaicon.saldo=10000;
        contaMaicon.chequeEspecial=5000;

            //metodos contas
        System.out.println("Conta Ana\n");
            contaAna.imprimirContaCorrente();
            contaAna.sacar(2000);
            contaAna.depositar(-5);

            System.out.println("Valor Saldo e Cheque especial Ana: "+contaAna.retornarSaldoComQuequeEspecial()+"\n");
        System.out.println("Conta Maicon\n");
            contaMaicon.imprimirContaCorrente();
            contaMaicon.sacar(-100);
            contaMaicon.depositar(2000);

            System.out.println("Valor Saldo e Cheque especial Maicon: "+contaMaicon.retornarSaldoComQuequeEspecial()+"\n");


            System.out.println("Valor Transferido? "+contaMaicon.trasferir(contaAna,1000)+"\n");
            System.out.println("Valor Saldo e Cheque especial Maicon: "+contaMaicon.retornarSaldoComQuequeEspecial()+"\n");
            System.out.println("Valor Saldo e Cheque especial Ana: "+contaAna.retornarSaldoComQuequeEspecial()+"\n");


    }
}
