package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.dto.PessoaCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.PessoaDTO;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import com.vemser.PrimeiroProjetoSpring.repository.PessoaRepository;
import com.vemser.PrimeiroProjetoSpring.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world!");
    }


    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.create(pessoa);
        return ResponseEntity.ok(pessoaDTO);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping // localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() throws Exception {
        return ResponseEntity.ok(pessoaService.list());
    }
    @GetMapping("/list_by_name") // localhost:8080/pessoa
    public ResponseEntity<List<PessoaEntity>> findByName(@RequestParam String nome) throws Exception {
        return ResponseEntity.ok(pessoaRepository.findByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/find_CPF")
    public ResponseEntity<PessoaEntity> findByCPF(@RequestParam String cpf) throws Exception {
        return ResponseEntity.ok(pessoaRepository.findByCpf(cpf));
    }
    @GetMapping("/find_By_Data_Nascimento")
    public ResponseEntity<List<PessoaEntity>> findByDataNascimentoBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate dataInicio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) throws Exception {
        return ResponseEntity.ok(pessoaRepository.findByDataNascimentoBetween(dataInicio, dataFim));
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
    public ResponseEntity delete(@PathVariable("idPessoa") Integer id) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.delete(id);
        return ResponseEntity.ok("");
    }
}

