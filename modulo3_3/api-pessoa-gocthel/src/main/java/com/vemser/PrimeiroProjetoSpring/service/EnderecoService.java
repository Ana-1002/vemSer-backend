package com.vemser.PrimeiroProjetoSpring.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.EnderecoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.EnderecoDTO;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoEntity;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoTipo;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO create(Integer id, EnderecoCreateDTO enderecoCreateDTO, EnderecoTipo tipo) throws Exception {

        EnderecoEntity endereco = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        endereco.setTipo(tipo);
        endereco.getPessoas().add(objectMapper.convertValue(pessoaService.getPessoaById(id), PessoaEntity.class));

        EnderecoEntity enderecoCriado = enderecoRepository.save(endereco);
        return objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id,
                              @Valid EnderecoCreateDTO enderecoAtualizar, EnderecoTipo tipo) throws Exception {
        EnderecoEntity enderecoEncontrada = enderecoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Endereco não encontrada!"));
        enderecoEncontrada.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEncontrada.setNumero(enderecoAtualizar.getNumero());
        enderecoEncontrada.setCep(enderecoAtualizar.getCep());
        enderecoEncontrada.setCidade(enderecoAtualizar.getCidade());
        enderecoEncontrada.setEstado(enderecoAtualizar.getEstado());
        enderecoEncontrada.setPais(enderecoAtualizar.getPais());
        enderecoEncontrada.setTipo(tipo);


        EnderecoEntity update = enderecoRepository.save(enderecoEncontrada);
        return objectMapper.convertValue(update, EnderecoDTO.class);
    }

    public List<EnderecoDTO>list(){
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO listEnderecoById(Integer id) throws Exception {
        EnderecoEntity enderecoEncontrada= enderecoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Endereco não encontrada!"));
        return objectMapper.convertValue(enderecoEncontrada, EnderecoDTO.class);
    }

    public EnderecoDTO delete(Integer id) throws Exception {
        EnderecoEntity endereco = enderecoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Endereco não encontrada!"));
        enderecoRepository.deleteById(id);
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

}

