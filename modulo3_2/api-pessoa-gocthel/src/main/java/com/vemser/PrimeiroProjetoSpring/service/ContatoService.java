package com.vemser.PrimeiroProjetoSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoDTO;
import com.vemser.PrimeiroProjetoSpring.entity.ContatoEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato){

        ContatoEntity contatoEntity1 = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntity1.setIdPessoa(idPessoa);
        ContatoEntity contatoEntityCriado = contatoRepository.save(contatoEntity1);

        return objectMapper.convertValue(contatoEntityCriado, ContatoDTO.class);

    }

    public List<ContatoDTO> list(){
        return contatoRepository.findAll()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id,
                         ContatoDTO contatoAtualizar) throws Exception {

        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(()->new RegraDeNegocioException("Contato não encontrada!"));
        contatoEntity.setDescricao(contatoAtualizar.getDescricao());
        contatoEntity.setNumero(contatoAtualizar.getNumero());
        contatoEntity.setTipo(contatoAtualizar.getTipo());

        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);


    }

    public ContatoDTO delete(Integer id) throws Exception {
        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(()->new RegraDeNegocioException("Contato não encontrada!"));
        contatoRepository.deleteById(id);

        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public List<ContatoDTO> listContatoById(Integer id) {
        return contatoRepository.findAll()
            .stream()
            .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
            .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
            .collect(Collectors.toList());

    }
}
