package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    Optional<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    Optional<PessoaEntity> findByCpf(String cpf);
    Optional<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);
}
