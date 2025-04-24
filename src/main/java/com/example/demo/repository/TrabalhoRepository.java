package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.TrabalhoModel;

public interface TrabalhoRepository extends JpaRepository<TrabalhoModel, Long>{

        @Query("SELECT t FROM TrabalhoModel t WHERE t.nota > :notaMinima AND LOWER(t.titulo) LIKE LOWER(CONCAT('%', :palavra, '%'))")
        List<TrabalhoModel> buscarTrabalhoPorPalavraNotaSuperior(
            @Param("notaMinima") Integer notaMinima,
            @Param("palavra") String palavra
        );
    }
