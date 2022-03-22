package com.vemser.PrimeiroProjetoSpring.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        PessoaEntity pessoa = objectMapper.convertValue(pessoaCreate, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoa);

        return objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
    }

    public PessoaDTO update(Integer id,
                                  PessoaDTO pessoaAtualizar) throws Exception {
       PessoaEntity pessoaEncontrada = pessoaRepository.findById(id)
               .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada!"));
       pessoaEncontrada.setCpf(pessoaAtualizar.getCpf());
       pessoaEncontrada.setDataNascimento(pessoaAtualizar.getDataNascimento());
       pessoaEncontrada.setNome(pessoaAtualizar.getNome());

       PessoaEntity update = pessoaRepository.save(pessoaEncontrada);
        return objectMapper.convertValue(update, PessoaDTO.class);
    }

    public List<PessoaDTO>list() throws Exception{
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getPessoaById(Integer id) throws Exception {
        PessoaEntity pessoaEncontrada= pessoaRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada!"));
        return objectMapper.convertValue(pessoaEncontrada, PessoaDTO.class);
    }

    public PessoaDTO delete(Integer id) throws Exception {
        PessoaEntity pessoa = pessoaRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada!"));
        pessoaRepository.deleteById(id);
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

}
