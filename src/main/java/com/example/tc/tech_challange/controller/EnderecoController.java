package com.example.tc.tech_challange.controller;

import com.example.tc.tech_challange.domain.ValidacaoException;
import com.example.tc.tech_challange.domain.ValidacaoException;
import com.example.tc.tech_challange.domain.endereco.*;
import com.example.tc.tech_challange.infra.TratadorDeErros;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;
    TratadorDeErros tratadorDeErros;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        var endereco = new Endereco(dados);
        repository.save(endereco);
        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));

    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemEndereco>> listar(@PageableDefault(size = 10, sort = {"cep"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemEndereco::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        try {
            var endereco = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
        } catch (Exception e){
            System.out.println("aqui estou");
            throw new ValidacaoException();
        }
    }
}
