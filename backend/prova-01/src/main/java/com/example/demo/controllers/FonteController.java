package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.FonteModel;
import com.example.demo.services.FonteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/fonte")
public class FonteController {
    @Autowired
    private FonteService fonteService;

    @PostMapping("")
    public ResponseEntity<?> cadastroFonte(@RequestBody FonteModel fonte){
        try {
            FonteModel fonteSalva = this.fonteService.cadastrarFonte(fonte);
            return ResponseEntity.status(201).body(fonteSalva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Descritivo deve ter pelo menos 4 caracteres!");
        } 
    }

    @GetMapping("")
    public ResponseEntity<List<FonteModel>> buscarFonte() {
        return ResponseEntity.ok().body(fonteService.listarTodasFontes());
    }

    @GetMapping("{potenciaMinima}/{dataMaxima}")
    public ResponseEntity<List<FonteModel>> buscaPotenciaRealGreaterThanAndDataLancamentoLessThan (@PathVariable("potenciaMinima") Integer potenciaMinima, @PathVariable("dataMaxima") LocalDate dataMaxima) {
        return ResponseEntity.ok().body(fonteService.buscarPotencia(potenciaMinima, dataMaxima));
    }
    
    
}
