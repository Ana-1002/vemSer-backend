package com.vemser.PrimeiroProjetoSpring.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import com.vemser.PrimeiroProjetoSpring.entity.Pessoa;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws Exception {

        Pessoa pessoa = objectMapper.convertValue(pessoaCreate, Pessoa.class);

        Pessoa pessoaCriada = pessoaRepository.create(pessoa);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        return pessoaDTO;
    }

    public PessoaDTO update(Integer id,
                                  PessoaDTO pessoaAtualizar) throws Exception {
        Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        pessoaRepository.update(id, pessoa);
        return pessoaAtualizar;
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);

    }

    public List<PessoaDTO>list(){
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getPessoaById(Integer id) throws Exception {
        Pessoa pessoa= pessoaRepository.getPessoaById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        return  pessoaDTO;
    }

    public PessoaDTO delete(Integer id) throws Exception {
        Pessoa pessoa = pessoaRepository.delete(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }


}
