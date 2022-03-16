package com.vemser.PrimeiroProjetoSpring.controller;
import com.vemser.PrimeiroProjetoSpring.entity.Contato;
import com.vemser.PrimeiroProjetoSpring.service.ContatoService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contato") // localhost:8080/contato
@Log
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping("/hello") // localhost:8080/contato/hello
    public String hello() {
        log.info("Acessou o método Hello!");
        return "Hello world!";
    }

    @PostMapping("/{idPessoa}") // localhost:8080/contato
    public Contato create(@PathVariable("idPessoa") Integer id,
                          @RequestBody Contato contato) throws Exception{
        log.info("Criou o contato");
        return contatoService.create(id, contato);
    }

    @GetMapping // localhost:8080/contato
    public List<Contato> list() {
        log.info("Listou os contatos");
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public List<Contato> listContatoById(@PathVariable("idPessoa") Integer id) {
        log.info("Listou o contato por id");
        return contatoService.listContatoById(id);
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public Contato update(@PathVariable("idContato") Integer id,
                         @RequestBody Contato contatoAtuallizar) throws Exception {
        log.info("Editou o contato");
        return contatoService.update(id, contatoAtuallizar);
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        log.info("Deletou o contato");
        contatoService.delete(id);
    }
}
