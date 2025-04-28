package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.AgendamentoModel;

import java.time.LocalDateTime;


public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long>{
    List<AgendamentoModel> findByDataHoraInicioGreaterThanAndInstrucoesContaining(LocalDateTime dataHoraInicio, String instrucoes);
}
