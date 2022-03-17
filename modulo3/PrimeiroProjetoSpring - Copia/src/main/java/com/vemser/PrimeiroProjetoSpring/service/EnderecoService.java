package com.vemser.PrimeiroProjetoSpring.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.EnderecoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.EnderecoDTO;
import com.vemser.PrimeiroProjetoSpring.entity.Endereco;
import com.vemser.PrimeiroProjetoSpring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO update(Integer id,
                              EnderecoCreateDTO pessoaAtualizar) throws Exception {
        Endereco endereco = objectMapper.convertValue(pessoaAtualizar, Endereco.class);
      endereco=  enderecoRepository.update(id, endereco);
      EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO>list(){
        return enderecoRepository.list()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listEnderecoById(Integer id){
        return enderecoRepository.listEnderecoById(id)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO delete(Integer id) throws Exception {
       Endereco endereco = enderecoRepository.delete(id);
       EnderecoDTO enderecoDTO= objectMapper.convertValue(endereco, EnderecoDTO.class);
    return enderecoDTO;
    }

    public EnderecoDTO create(Integer id, EnderecoCreateDTO pessoaCreate) throws Exception {

        Endereco endereco = objectMapper.convertValue(pessoaCreate, Endereco.class);
        Endereco endereco1 = enderecoRepository.create(id, endereco);
        EnderecoDTO enderecoDTO= objectMapper.convertValue(endereco1, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> listEnderecoByIdPessoa(Integer id){
       return enderecoRepository.listEnderecoByIdPessoa(id)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
}

