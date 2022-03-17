package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.dto.PessoaCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import com.vemser.PrimeiroProjetoSpring.entity.Pessoa;
import com.vemser.PrimeiroProjetoSpring.service.EmailService;
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
    @Autowired
    private EmailService emailService;
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world!");
    }

    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.create(pessoa);
        emailService.pessoaSendEmail(pessoaDTO, "Seu cadastro foi realizado com sucesso, seu identificador é "+pessoaDTO.getIdPessoa()+".", "Cadastro");
        return ResponseEntity.ok(pessoaDTO);
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
        emailService.pessoaSendEmail(pessoaAtualizar, "Seus dados foram atualizados no nosso sistema.", "Atualização de dados");
        return  ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public ResponseEntity delete(@PathVariable("idPessoa") Integer id) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.delete(id);
        emailService.pessoaSendEmail(pessoaDTO, "Você perdeu o acesso ao nosso sistema.", " Delet de conta");
        return ResponseEntity.ok("");
    }
}

