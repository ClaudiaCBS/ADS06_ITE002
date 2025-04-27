package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PatrimonioModel;
import java.time.LocalDate;


public interface PatrimonioRepository extends JpaRepository<PatrimonioModel, Long>{
    List<PatrimonioModel> findByDataAquisicaoGreaterThanAndValorLessThan(LocalDate dataAquisicao, Float valor);
}
