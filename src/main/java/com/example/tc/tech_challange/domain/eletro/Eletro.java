package com.example.tc.tech_challange.domain.eletro;

import com.example.tc.tech_challange.domain.pessoas.Genero;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Table(name = "eletro")
@Entity(name = "Eletro")

public class Eletro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String ean;
    private String marca;
    private int potencia;
    @Enumerated(EnumType.STRING)
    private Voltagem voltagem;
    //private int horasDia;


    public Eletro(DadosCadastroEletro dados) {
        this.titulo = dados.titulo();
        this.ean = dados.ean();
        this.marca = dados.marca();
        this.potencia = dados.potencia();
        this.voltagem = dados.voltagem();
        //this.horasDia = dados.horasDia();
    }
}
