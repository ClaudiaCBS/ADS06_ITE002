package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.TarifaModel;

public interface TarifaRepository extends JpaRepository<TarifaModel, Long>{
    List<TarifaModel> findByNomeAndDataInicioLessThan(String nome, LocalDate data);
    }
