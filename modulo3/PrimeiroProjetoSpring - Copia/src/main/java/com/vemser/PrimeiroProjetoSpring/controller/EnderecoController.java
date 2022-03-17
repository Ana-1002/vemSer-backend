package com.vemser.PrimeiroProjetoSpring.controller;

import com.vemser.PrimeiroProjetoSpring.dto.EnderecoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.EnderecoDTO;
import com.vemser.PrimeiroProjetoSpring.service.EmailService;
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
    @Autowired
    private EmailService emailService;
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
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") @Valid Integer id, @RequestBody  @Valid EnderecoCreateDTO endereco) throws Exception {
        log.info("Criou um endereço");
        EnderecoDTO enderecoDTO = enderecoService.create(id, endereco);
        emailService.enderecoModificadosendEmail(id, "Seu endereço foi cadastrado com sucesso, seu identificador é "+enderecoDTO.getIdEndereco(), "Cadastro de Edereço");
        return ResponseEntity.ok(enderecoDTO);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") @Valid Integer id, @RequestBody @Valid EnderecoCreateDTO endereco) throws Exception {
        log.info("Editou o endereco de id " + id);
        EnderecoDTO enderecoDTO = enderecoService.update(id, endereco);
        emailService.enderecoModificadosendEmail(id, "Seu endereço foi Atualizado com sucesso.", "Atualização de Edereço");
        return ResponseEntity.ok(enderecoDTO);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> delete(@PathVariable("idEndereco") @Valid Integer id) throws Exception {
        log.info("Deletou o endereco de id " + id);
        emailService.enderecoModificadosendEmail(id, "Seu endereço de id "+id+", foi Deletado com sucesso.", "Delete de Edereço");
        return ResponseEntity.ok(enderecoService.delete(id));
    }

}
