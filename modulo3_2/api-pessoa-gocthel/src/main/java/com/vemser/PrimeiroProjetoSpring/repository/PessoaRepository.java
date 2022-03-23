package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);
}
