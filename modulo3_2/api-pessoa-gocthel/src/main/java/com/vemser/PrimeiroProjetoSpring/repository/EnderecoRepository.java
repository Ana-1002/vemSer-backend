package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository  extends JpaRepository<EnderecoEntity, Integer> {
}
