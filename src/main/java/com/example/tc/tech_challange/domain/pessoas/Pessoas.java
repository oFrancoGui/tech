package com.example.tc.tech_challange.domain.pessoas;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "pessoas")
@Entity(name = "Pessoas")


public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private Date data;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Pessoas (DadosCadastroPessoa dados){
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.email = dados.email();
        this.data = dados.data();
        this.genero = dados.genero();
    }
}







