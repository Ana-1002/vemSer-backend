package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.entity.Endereco;
import com.vemser.PrimeiroProjetoSpring.service.EnderecoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/endereco") // localhost:8080/contato
@Log
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list()
    {log.info("Listou endereços");
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listEnderecoById(@PathVariable("idEndereco") Integer id){
        log.info("Listou endereço do id "+id);
        return enderecoService.listEnderecoById(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listEnderecoByIdPessoa(@PathVariable("idPessoa") Integer id){
        log.info("Listou enderecos da pessoa de id "+id);
        return enderecoService.listEnderecoByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco){
        log.info("Criou um endereço");
        return enderecoService.create(id, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id, @RequestBody Endereco endereco) throws Exception{
        log.info("Editou o endereco de id "+id);
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception{
        log.info("Deletou o endereco de id "+id);
        enderecoService.delete(id);
    }

}
