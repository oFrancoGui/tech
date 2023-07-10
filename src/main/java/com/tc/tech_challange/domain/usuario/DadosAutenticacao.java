package com.tc.tech_challange.domain.usuario;

import jakarta.validation.constraints.Email;

public record DadosAutenticacao(
        //@Email(message = "email invalido")
        String login,
        String senha)
{
}
