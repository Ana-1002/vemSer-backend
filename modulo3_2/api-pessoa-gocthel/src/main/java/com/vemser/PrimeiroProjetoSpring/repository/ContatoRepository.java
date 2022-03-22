package com.vemser.PrimeiroProjetoSpring.repository;

import com.vemser.PrimeiroProjetoSpring.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository  extends JpaRepository<ContatoEntity, Integer> {
}
