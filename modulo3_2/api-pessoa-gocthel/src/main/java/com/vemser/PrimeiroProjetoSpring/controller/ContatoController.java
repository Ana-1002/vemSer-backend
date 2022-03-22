package com.vemser.PrimeiroProjetoSpring.controller;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoCreateDTO;
import com.vemser.PrimeiroProjetoSpring.dto.ContatoDTO;
import com.vemser.PrimeiroProjetoSpring.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Retorna um Hello World!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um hello world"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/hello") // localhost:8080/contato/hello
    public String hello() {
        log.info("Acessou o método Hello!");
        return "Hello world!";
    }

    @ApiOperation(value = "Retorna a criação de um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a criação de um contato"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}") // localhost:8080/contato
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") @Valid Integer id,
                                                   @RequestBody @Valid ContatoCreateDTO contato) throws Exception{
        log.info("Criou o contato");
        return ResponseEntity.ok(contatoService.create(id, contato));
    }
    @ApiOperation(value = "Retorna uma lista de contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou uma lista de contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping // localhost:8080/contato
    public ResponseEntity<List<ContatoDTO>> list() {
        log.info("Listou os contatos");
        return ResponseEntity.ok(contatoService.list());
    }
    @ApiOperation(value = "Retorna uma lista de contatos pelo id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou uma lista de contatos pelo id da pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idPessoa}") // localhost:8080/contato/1
    public ResponseEntity<List<ContatoDTO>> listContatoById(@PathVariable("idPessoa") @Valid Integer id) {
        log.info("Listou o contato por id");
        return ResponseEntity.ok(contatoService.listContatoById(id));
    }

    @ApiOperation(value = "Edita um contato pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Editou um contato pelo seu id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idContato}") // localhost:8080/contato/1000
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") @Valid Integer id,
                         @RequestBody @Valid ContatoDTO contatoAtuallizar) throws Exception {
        log.info("Editou o contato");
        return ResponseEntity.ok(contatoService.update(id, contatoAtuallizar));
    }

    @ApiOperation(value = "Deletou um contato pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou um contato pelo seu id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idContato}") // localhost:8080/contato/10
    public ResponseEntity<ContatoDTO> delete(@PathVariable("idContato") @Valid Integer id) throws Exception {
        log.info("Deletou o contato");
        return ResponseEntity.ok(contatoService.delete(id));
    }
}
