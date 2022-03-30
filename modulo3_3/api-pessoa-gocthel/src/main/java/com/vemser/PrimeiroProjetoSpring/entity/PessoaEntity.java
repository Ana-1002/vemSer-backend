package com.vemser.PrimeiroProjetoSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PESSOA")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name= "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @JsonIgnore
    @OneToMany (mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<EnderecoEntity> enderecos;
}
