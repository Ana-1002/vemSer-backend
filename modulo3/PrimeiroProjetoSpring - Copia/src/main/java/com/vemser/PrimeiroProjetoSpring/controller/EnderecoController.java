package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.dto.EnderecoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.EnderecoDTO;
import com.vemser.PrimeiroProjetoSpring.service.EnderecoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/endereco") // localhost:8080/contato
@Log
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        log.info("Listou endereços");
        return ResponseEntity.ok(enderecoService.list());
    }

    @GetMapping("/{idEndereco}")
    public  ResponseEntity<List<EnderecoDTO>> listEnderecoById(@PathVariable("idEndereco") @Valid Integer id) {
        log.info("Listou endereço do id " + id);
        return ResponseEntity.ok(enderecoService.listEnderecoById(id));
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listEnderecoByIdPessoa(@PathVariable("idPessoa") @Valid Integer id) {
        log.info("Listou enderecos da pessoa de id " + id);
        return ResponseEntity.ok(enderecoService.listEnderecoByIdPessoa(id));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") @Valid Integer id, @RequestBody  @Valid EnderecoDTO endereco) throws Exception {
        log.info("Criou um endereço");
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") @Valid Integer id, @RequestBody @Valid EnderecoCreateDTO endereco) throws Exception {
        log.info("Editou o endereco de id " + id);
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> delete(@PathVariable("idEndereco") @Valid Integer id) throws Exception {
        log.info("Deletou o endereco de id " + id);
        return ResponseEntity.ok(enderecoService.delete(id));
    }

}
