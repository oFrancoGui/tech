package com.example.tc.tech_challange.domain.endereco;

public record DadosListagemEndereco(int id, int cep, String rua, int numero, String compl, String bairro, String cidade, String estado) {

    public DadosListagemEndereco(Endereco endereco){
        this(endereco.getId(), endereco.getCep(),endereco.getRua(), endereco.getNumero(), endereco.getCompl(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }

}
