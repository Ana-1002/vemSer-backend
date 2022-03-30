package com.vemser.PrimeiroProjetoSpring.repository;
import com.vemser.PrimeiroProjetoSpring.entity.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query( value="SELECT * "
            +" FROM VEM_SER.ENDERECO_PESSOA e"
            +" WHERE e.cidade = :cidade OR e.pais = :pais",nativeQuery = true
    ) List<EnderecoEntity> findEnderecoByCidadeOrPaisNative(String cidade, String pais);

    @Query( value="SELECT * "
            +" FROM VEM_SER.ENDERECO_PESSOA e"
            +" WHERE e.complemento IS NULL ",nativeQuery = true
    ) List<EnderecoEntity> findEnderecoSemComplementoNative();

    @Query( value="SELECT e "
            +" FROM ENDERECO_PESSOA e "
            +" ORDER BY :pais")
    Page<EnderecoEntity> findAllPagFilradaPorPais(String pais, Pageable pageable);


//    @Query("select e "+
//            "from ENDERECO_PESSOA e "+
//            "where e.idEndereco = :id ")
//    List<EnderecoEntity> findEnderecoByIdJPQL(Integer id);

}
