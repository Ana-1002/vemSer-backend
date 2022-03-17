package com.vemser.PrimeiroProjetoSpring.controller;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoDTO;
import com.vemser.PrimeiroProjetoSpring.entity.Contato;
import com.vemser.PrimeiroProjetoSpring.service.ContatoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/contato") // localhost:8080/contato
@Log
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping("/hello") // localhost:8080/contato/hello
    public String hello() {
        log.info("Acessou o método Hello!");
        return "Hello world!";
    }

    @PostMapping("/{idPessoa}") // localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") @Valid Integer id,
                                                   @RequestBody @Valid ContatoCreateDTO contato) throws Exception{
        log.info("Criou o contato");
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @GetMapping // localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> list() {
        log.info("Listou os contatos");
        return ResponseEntity.ok(contatoService.list());
    }

    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public ResponseEntity<List<Contato>> listContatoById(@PathVariable("idPessoa") @Valid Integer id) {
        log.info("Listou o contato por id");
        return ResponseEntity.ok(contatoService.listContatoById(id));
    }

    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") @Valid Integer id,
                         @RequestBody @Valid ContatoDTO contatoAtuallizar) throws Exception {
        log.info("Editou o contato");
        return ResponseEntity.ok(contatoService.update(id, contatoAtuallizar));
    }

    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public ResponseEntity<ContatoDTO> delete(@PathVariable("idContato") @Valid Integer id) throws Exception {
        log.info("Deletou o contato");
        return ResponseEntity.ok(contatoService.delete(id));
    }
}
