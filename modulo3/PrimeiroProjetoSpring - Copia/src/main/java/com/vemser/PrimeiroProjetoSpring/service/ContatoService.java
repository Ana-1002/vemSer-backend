package com.vemser.PrimeiroProjetoSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoDTO;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import com.vemser.PrimeiroProjetoSpring.entity.Contato;
import com.vemser.PrimeiroProjetoSpring.entity.Pessoa;
import com.vemser.PrimeiroProjetoSpring.repository.ContatoRepository;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato){

        Contato contato1 = objectMapper.convertValue(contato, Contato.class);

        Contato contatoCriado = contatoRepository.create(idPessoa,contato1);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id,
                         ContatoDTO contatoAtualizar) throws Exception {
        Contato contato1 = objectMapper.convertValue(contatoAtualizar, Contato.class);

        Contato contatoUpdate = contatoRepository.create(id,contato1);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoUpdate, ContatoDTO.class);

        return contatoDTO;

    }

    public ContatoDTO delete(Integer id) throws Exception {
        Contato contato = contatoRepository.delete(id);
        ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
        return contatoDTO;
    }

    public List<Contato> listContatoById(Integer id) {
        return contatoRepository.listContatoById(id);
    }
}
