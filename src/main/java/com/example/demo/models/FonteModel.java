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
@Table(name = "fon_fonte")
public class FonteModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Column(name = "fon_descritivo", nullable = false, unique = true)
    private String descritivo;

    @Column(name = "fon_preco_sugerido")
    private Float precoSugerido;

    @Column(name = "fon_data_lancamento", nullable = false)
    private LocalDate dataLancamento;

    @Column(name = "fon_potencia_real")
    private Integer potenciaReal;

    @Column(name = "fon_potencia_nominal", nullable = false)
    private Integer potenciaNominal;
    
}
