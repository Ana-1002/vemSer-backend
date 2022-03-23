package com.vemser.PrimeiroProjetoSpring.repository;

import com.vemser.PrimeiroProjetoSpring.entity.ContatoEntity;
import com.vemser.PrimeiroProjetoSpring.entity.ContatoTipo;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository  extends JpaRepository<ContatoEntity, Integer> {
    @Query( "SELECT c from Contato c "+
    " where c.tipo = :tipo ")
    List<ContatoEntity> findContatoByTipoJSQL(ContatoTipo tipo);

}
