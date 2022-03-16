package com.vemser.PrimeiroProjetoSpring.service;

import com.vemser.PrimeiroProjetoSpring.entity.Contato;
import com.vemser.PrimeiroProjetoSpring.repository.ContatoRepository;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Integer idPessoa, Contato contato){
        return contatoRepository.create(idPessoa, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listContatoById(Integer id) {
        return contatoRepository.listContatoById(id);
    }
}
