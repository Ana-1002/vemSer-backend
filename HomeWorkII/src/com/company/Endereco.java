package com.company;

public class Endereco {

        public Endereco(){

        }

        private int tipoEnd;
        private String logradouro;
        private int numero;
        private String complemento;
        private String cep;
        private String cidade;
        private String estado;
        private String pais;

        public void imprimirEndereco(){
            System.out.println(
                    "Endereço:    "+tipoEnd+"\n"+
                            "Número:      "+numero+"\n"+
                            "Complemento: "+complemento+"\n"+
                            "Cep:        "+cep+"\n"+
                            "Cidade:     "+cidade+"\n"+
                            "Estado:     "+estado+"\n"+
                            "País:       "+pais+"\n"
            );
        }

        public int getTipoEnd() {
                return tipoEnd;
        }

        public void setTipoEnd(int tipoEnd) {
                this.tipoEnd = tipoEnd;
        }

        public String getLogradouro() {
                return logradouro;
        }

        public void setLogradouro(String logradouro) {
                this.logradouro = logradouro;
        }

        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        }

        public String getComplemento() {
                return complemento;
        }

        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }

        public String getCep() {
                return cep;
        }

        public void setCep(String cep) {
                this.cep = cep;
        }

        public String getCidade() {
                return cidade;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public String getPais() {
                return pais;
        }

        public void setPais(String pais) {
                this.pais = pais;
        }
}
