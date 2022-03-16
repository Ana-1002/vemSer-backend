package com.vemser.PrimeiroProjetoSpring.repository;

import com.vemser.PrimeiroProjetoSpring.entity.Contato;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, "Ana", "12345678910"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 1, "Pedro", "12345678911"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 2, "Thiago", "12345678912"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 3, "João", "12345678916"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 4, "Maria", "12345678917"));
    }

    public Contato create(Integer idPessoa, Contato contato) {
        contato.setIdPessoa(idPessoa);
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));

        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setNumeroContato(contatoAtualizar.getNumeroContato());
        contatoRecuperado.setNomeContato(contatoAtualizar.getNomeContato());
        contatoRecuperado.setNomeContato(contatoAtualizar.getNomeContato());
        return contatoRecuperado;
    }
    public Contato delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato()==id)
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        listaContatos.remove(contatoRecuperado);
        return contatoRecuperado;
    }

    public List<Contato> listContatoById(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa()==id)
                .collect(Collectors.toList());
    }

}
