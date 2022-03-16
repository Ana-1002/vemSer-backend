package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.dto.PessoaCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import com.vemser.PrimeiroProjetoSpring.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

//    public PessoaController() {
//        pessoaService = new PessoaService();
//    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world!");
    }

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return ResponseEntity.ok(pessoaService.list());
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> getPessoaById(@PathVariable("idPessoa") Integer id) throws Exception {
        return ResponseEntity.ok(pessoaService.getPessoaById(id));
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @Valid @RequestBody PessoaDTO pessoaAtualizar) throws Exception {
        return  ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public ResponseEntity<PessoaDTO> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        return ResponseEntity.ok(pessoaService.delete(id));
    }
}

