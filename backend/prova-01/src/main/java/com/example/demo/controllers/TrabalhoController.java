package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TrabalhoModel;
import com.example.demo.services.TrabalhoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/trabalho")
public class TrabalhoController {
    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping("")
    public ResponseEntity<?> cadastroTrabalho(@RequestBody TrabalhoModel trabalhoModel){
        try {
            TrabalhoModel trabalhoSalvo = this.trabalhoService.cadastrarTrabalho(trabalhoModel);
            return ResponseEntity.created(null).body(trabalhoSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } 
    }

    @GetMapping("")
    public ResponseEntity<List<TrabalhoModel>> buscarTrabalhos() {
        return ResponseEntity.ok().body(trabalhoService.listarTodosTrabalhos());
    }

    @GetMapping("{palavra}/{notaMinima}")
    public ResponseEntity<List<TrabalhoModel>> buscarTrabalhoNotaMinimaPalavra (@PathVariable("palavra") String palavra, @PathVariable("notaMinima") Integer notaMinima) {
        return ResponseEntity.ok().body(trabalhoService.listarPalavraNotaMinima(palavra, notaMinima));
    }
    
    
}
