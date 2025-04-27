package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.FonteModel;

public interface FonteRespository extends JpaRepository<FonteModel, Long>{

    @Query("SELECT f FROM FonteModel f WHERE f.potenciaReal > :valorPassado AND f.dataLancamento < :outroParametro")
    List<FonteModel> buscaPotenciaRealGreaterThanAndDataLancamentoLessThan(
        @Param("valorPassado") Integer valorPassado,
        @Param("outroParametro") LocalDate outroParametro
    );
}
