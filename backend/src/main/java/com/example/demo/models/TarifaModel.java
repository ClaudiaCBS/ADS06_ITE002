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
@Table(name = "tar_tarifa")
public class TarifaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "tar_nome", nullable = false)
    private String nome;

    @Column(name = "tar_aliquota", nullable = false)
    private Float aliquota;

    @Column(name = "tar_data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "tar_data_termino")
    private LocalDate dataTermino;

    @Column(name = "tar_impacto")
    private Integer impacto;
    
}
