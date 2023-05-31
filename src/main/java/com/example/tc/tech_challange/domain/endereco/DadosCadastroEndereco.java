package com.example.tc.tech_challange.domain.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroEndereco(
        @NotBlank
        int id,
        @NotBlank @NotEmpty
        int cep,
        @NotBlank
        String rua,
        @NotBlank
        int numero,
        @NotBlank
        String compl,
        @NotBlank
        String bairro,
        @NotBlank

        String cidade,
        @NotBlank
        String estado
        )


{ }
