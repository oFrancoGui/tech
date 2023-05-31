package com.example.tc.tech_challange.domain.pessoas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public record DadosDetalhamentoPessoas (String cpf, String nome, String email, Date data, Genero genero) {
      public DadosDetalhamentoPessoas (Pessoas pessoas) {
        this(pessoas.getCpf(),pessoas.getNome(),pessoas.getEmail(),pessoas.getData(), pessoas.getGenero());

    }

}
