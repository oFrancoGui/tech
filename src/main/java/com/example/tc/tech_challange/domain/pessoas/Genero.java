package com.example.tc.tech_challange.domain.pessoas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genero {

    MASCULINO("M"),
    FEMININO("F");
    private final String GeneroDescricao;

}
