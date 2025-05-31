package com.example.demo.models;

import java.time.LocalDateTime;

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
@Table(name = "age_agendamento")
public class AgendamentoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Column(name = "age_instrucoes")
    private String instrucoes;

    @Column(name = "age_valor")
    private Float valor;

    @Column(name = "age_data_hora_inicio", nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(name = "age_duracao_prevista")
    private Integer duracao;
}
