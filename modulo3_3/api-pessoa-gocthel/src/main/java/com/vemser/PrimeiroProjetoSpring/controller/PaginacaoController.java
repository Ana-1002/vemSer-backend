package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.entity.ContatoEntity;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoEntity;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import com.vemser.PrimeiroProjetoSpring.repository.ContatoRepository;
import com.vemser.PrimeiroProjetoSpring.repository.EnderecoRepository;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao") // localhost:8080/pessoa
@RequiredArgsConstructor
public class PaginacaoController {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;

    private final EnderecoRepository enderecoRepository;

    @GetMapping("/find-all-contatos-Ordenado-pela-descricao")
    public Page<ContatoEntity> findALlPaginadoEOrdenadoDescricao(Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("descricao"));
        Page<ContatoEntity> all = contatoRepository.findAll(pageable);
        return all;
    }
    @GetMapping("/find-all-endereco-ordenado-pelo-cep")
    public Page<EnderecoEntity> findALlEndereciOrdenadoPeloCep(Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("cep"));
        Page<EnderecoEntity> all = enderecoRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/enderecos-filtrado-pais")
    public Page<EnderecoEntity> findALlEndereciFiltradoPeloCep(Integer paginaSolicitada, Integer tamanhoDaPagina, String pais){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina);
        return enderecoRepository.findAllPagFilradaPorPais(pais, pageable);
}
}
