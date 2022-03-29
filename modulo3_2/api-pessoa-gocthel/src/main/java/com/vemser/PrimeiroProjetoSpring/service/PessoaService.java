package com.vemser.PrimeiroProjetoSpring.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.PrimeiroProjetoSpring.dto.*;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import com.vemser.PrimeiroProjetoSpring.exception.RegraDeNegocioException;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;


    public List<PessoaDTOCompleto> listCompleto(Integer idPessoa) throws RegraDeNegocioException {
           List<PessoaDTOCompleto> pessoaDTOCompletos = new ArrayList<>();
        if(idPessoa == null){
        pessoaDTOCompletos.addAll(pessoaRepository.findPessoaComEnderecoEContatoJPQL()
                   .stream()
                   .map(pessoaEntity -> {
                       PessoaDTOCompleto pessoaDTOCompleto = objectMapper.convertValue(pessoaEntity, PessoaDTOCompleto.class);
                       pessoaDTOCompleto.setContatos(pessoaEntity.getContatos().stream()
                               .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                               .collect(Collectors.toList())
                       );
                       pessoaDTOCompleto.setEnderecos(pessoaEntity.getEnderecos().stream()
                               .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                               .collect(Collectors.toList())
                       );
                       return pessoaDTOCompleto;
                   }).collect(Collectors.toList()));
        return pessoaDTOCompletos;
    }else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOCompleto pessoaDTOCompleto = objectMapper.convertValue(pessoaEntity, PessoaDTOCompleto.class);
            pessoaDTOCompleto.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTOCompleto.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTOCompletos.add(pessoaDTOCompleto);
        }
        return pessoaDTOCompletos;
    }

    public List<PessoaDTOComContatos> listComContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComContatos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );

                        return pessoaDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }
    public List<PessoaDTOComEnderecos> listComEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComEnderecos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaDTOComEnderecos = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                       pessoaDTOComEnderecos.setEnderecos(pessoa.getEnderecos().stream()
                                 .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList())
                        );

                        return pessoaDTOComEnderecos;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }


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
