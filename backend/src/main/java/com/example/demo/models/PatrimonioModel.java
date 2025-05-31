package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pat_patrimonio")
public class PatrimonioModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "pat_descricao")
    private String descricao;

    @Column(name = "pat_data_aquisicao")
    private LocalDate dataAquisicao;

    @Column(name = "pat_data_venda")
    private LocalDate dataVenda;


    @Column(name = "pat_valor")
    private Float valor;


    @Column(name = "pat_tipo")
    private String tipo;
}
