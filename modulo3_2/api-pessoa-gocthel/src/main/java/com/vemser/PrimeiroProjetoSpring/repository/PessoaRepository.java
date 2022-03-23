package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("select p from PESSOA p "
            + "where p.dataNascimento BETWEEN :valor_inicial AND :valor_final")
    List<PessoaEntity> findByDataNascimentoBetweenJSQL(LocalDate valor_inicial, LocalDate valor_final);

    @Query("select p "+
            "from PESSOA p "+
            "join fetch p.enderecos e ")
    List<PessoaEntity> findPessoaByEnderecoJPQL();

    @Query(value = "select * "+
            "from VEM_SER.PESSOA p "+
            "LEFT JOIN VEM_SER.Pessoa_X_Pessoa_Endereco pe on p.id_pessoa = pe.id_pessoa "+
            "WHERE pe.id_pessoa IS NULL", nativeQuery = true )
    List<PessoaEntity> findPessoaSemEndereco();
}
