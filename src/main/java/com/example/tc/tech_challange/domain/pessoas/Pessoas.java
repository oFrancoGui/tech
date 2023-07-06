package com.example.tc.tech_challange.domain.pessoas;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pessoas")


public class Pessoas {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid")
    private UUID id;
    @Column(name="cpf")
    private String cpf;
    @Column(name="nome")
    private String nome;
    @Column(name="email")
    private String email;
    @Column(name="data")
    private Date data;
    @Enumerated(EnumType.STRING)
    @Column(name="genero")
    private Genero genero;

    public Pessoas (DadosCadastroPessoa dados){
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.email = dados.email();
        this.data = dados.data();
        this.genero = dados.genero();
    }
}







