package com.example.chatkafka.entity;

public enum TopicsEnum {
        GERAL("chat-geral"), ANA("chat-ana"), EZEQUIAS("chat-ezequias"), FLAVIO("chat-flavio"), FELIPE("chat-felipe"),
        GABRIEL("chat-gabriel"), GUILHERME("chat-guilherme"), GUSTAVO("chat-gustavo"), JOAO("chat-joao"), LUCAS("chat-lucas"),
        LUIZ("chat-luiz"), MAICON("chat-maicon"), NICOLAS("chat-nicolas"), PABLO("chat-pablo");

        private String nome;

    TopicsEnum(String nome){
            this.nome = nome;
        }


    public String getNome() {
            return nome;
        }
}
