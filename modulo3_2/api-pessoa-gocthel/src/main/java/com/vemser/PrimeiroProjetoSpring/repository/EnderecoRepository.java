package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository  extends JpaRepository<EnderecoEntity, Integer> {

    @Query("select e from ENDERECO_PESSOA e "
            + "where e.pais = :pais")
    List<EnderecoEntity> findEnderecoByPaisJPQL(String pais);

    @Query("select e "+
            "from ENDERECO_PESSOA e "+
            "join fetch e.pessoas p "+
            "where p.idPessoa = :id ")
    List<EnderecoEntity> findEnderecoByIdJPQL(Integer id);

//    @Query("select e "+
//            "from ENDERECO_PESSOA e "+
//            "where e.idEndereco = :id ")
//    List<EnderecoEntity> findEnderecoByIdJPQL(Integer id);

}
