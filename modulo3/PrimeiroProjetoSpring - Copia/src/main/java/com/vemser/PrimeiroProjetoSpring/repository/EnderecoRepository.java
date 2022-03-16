package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    PessoaRepository pessoaRepository;

    public EnderecoRepository() {
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*1*/,1 , "casa","956874111", "1","Rua tal","butia", "estado", "pais"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*2*/, 2,"casa","956874111", "2", "Rua tal1","butia", "estado", "pais"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*3*/,3,"casa","956874111", "3", "Rua tal3","butia", "estado", "pais"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*4*/, 4, "casa","956874111","4", "Rua tal4","butia", "estado", "pais"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet() /*5*/,5, "casa","956874111","5", "Rua tal5","butia", "estado", "pais"));
    }

    public Endereco create (Integer id, Endereco endereco){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(id);
      listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list(){
        return listaEndereco;
    }

    public List<Endereco> listEnderecoById(Integer id) {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco()==id)
                .collect(Collectors.toList());
    }

    public List<Endereco> listEnderecoByIdPessoa(Integer id) {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdPessoa()==id)
                .collect(Collectors.toList());
    }

    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoUpdate = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));

        enderecoUpdate.setIdPessoa(id);
        enderecoUpdate.setNumeroCasa(enderecoAtualizar.getNumeroCasa());
        enderecoUpdate.setLogradouro(enderecoAtualizar.getLogradouro());
        return enderecoUpdate;
    }

    public Endereco delete(Integer id) throws Exception {
        Endereco enderecoDel = listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco()==id)
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
         listaEndereco.remove(enderecoDel);
         return enderecoDel;
    }

}
