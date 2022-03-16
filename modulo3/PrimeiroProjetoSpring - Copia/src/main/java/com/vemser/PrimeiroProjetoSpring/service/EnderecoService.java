package com.vemser.PrimeiroProjetoSpring.service;
import com.vemser.PrimeiroProjetoSpring.entity.Endereco;
import com.vemser.PrimeiroProjetoSpring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Integer id, Endereco endereco){
        return enderecoRepository.create(id, endereco);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public List<Endereco> listEnderecoById(Integer id){
        return enderecoRepository.listEnderecoById(id);
    }
    public List<Endereco> listEnderecoByIdPessoa(Integer id){
        return enderecoRepository.listEnderecoByIdPessoa(id);
    }

    public  Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        return enderecoRepository.update(id, enderecoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }

}

