package com.example.tc.tech_challange.domain.eletro;

import com.example.tc.tech_challange.domain.eletro.DadosDetalhamentoEletro;
import com.example.tc.tech_challange.domain.eletro.Eletro;

public record DadosDetalhamentoEletro(String titulo, String ean, String marca, int potencia, Voltagem voltagem) {
    public DadosDetalhamentoEletro (Eletro eletro){
        this(eletro.getTitulo(),eletro.getEan(),eletro.getMarca(),eletro.getPotencia(),eletro.getVoltagem());
    }
}
