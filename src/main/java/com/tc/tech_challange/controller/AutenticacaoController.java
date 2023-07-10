package com.tc.tech_challange.controller;

import jakarta.validation.Valid;
import com.tc.tech_challange.domain.usuario.DadosAutenticacao;
import com.tc.tech_challange.domain.usuario.Usuario;
import com.tc.tech_challange.infra.security.DadosTokenJWT;
import com.tc.tech_challange.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("api/v2/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        System.out.println(tokenJWT);
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}