package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TarifaModel;
import com.example.demo.services.TarifaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    private TarifaService tarifaService;

    @PostMapping("")
    public ResponseEntity<TarifaModel> cadastrarTarifa(@RequestBody TarifaModel tarifa) {
        TarifaModel novaTarifa = tarifaService.cadastrarTarifa(tarifa);
        return ResponseEntity.ok(novaTarifa);
    }

    @GetMapping("")
    public ResponseEntity<List<TarifaModel>> listarTodasTarifas() {
        return ResponseEntity.ok(tarifaService.listarTodasTarifas());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<TarifaModel>> buscarTarifasPorNomeEData(@RequestParam String nome, @RequestParam String data) {
        List<TarifaModel> tarifas = tarifaService.buscarPorNomeDataAnterior(nome, LocalDate.parse(data));
        return ResponseEntity.ok(tarifas);
    }
    
}
