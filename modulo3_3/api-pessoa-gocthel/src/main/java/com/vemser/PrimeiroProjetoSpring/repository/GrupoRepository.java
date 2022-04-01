package com.vemser.PrimeiroProjetoSpring.repository;

import com.vemser.PrimeiroProjetoSpring.entity.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository  extends JpaRepository<GrupoEntity, Integer> {
}
