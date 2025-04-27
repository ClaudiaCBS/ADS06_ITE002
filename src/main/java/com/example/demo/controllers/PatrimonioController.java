package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.PatrimonioModel;
import com.example.demo.services.PatrimonioService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patrimonios")
public class PatrimonioController {

    @Autowired
    private PatrimonioService patrimonioService;

    @PostMapping
    public ResponseEntity<PatrimonioModel> cadastrarPatrimonio(@RequestBody PatrimonioModel patrimonio) {
        try {
            PatrimonioModel patrimonioSalvo = patrimonioService.cadastrarPatrimonio(patrimonio);
            return ResponseEntity.status(HttpStatus.CREATED).body(patrimonioSalvo);
        } catch (ResponseStatusException e) {
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<List<PatrimonioModel>> listarTodosPatrimonios() {
        List<PatrimonioModel> patrimonios = patrimonioService.listarPatrimonio();
        return ResponseEntity.ok(patrimonios);
    }

    @GetMapping("/{dataAquisicao}/{valor}")
    public ResponseEntity<List<PatrimonioModel>> listarPorDataEValor(
            @PathVariable("dataAquisicao") LocalDate dataAquisicao,
            @PathVariable("valor") Float valor) {
        List<PatrimonioModel> patrimonios = patrimonioService.listarPorDataAquisicaoEValor(dataAquisicao, valor);
        return ResponseEntity.ok(patrimonios);
    }
}