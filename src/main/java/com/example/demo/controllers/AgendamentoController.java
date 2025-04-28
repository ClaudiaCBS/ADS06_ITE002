package com.example.demo.controllers;

import com.example.demo.models.AgendamentoModel;
import com.example.demo.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoModel>> buscarTodosAgendamentos() {
        List<AgendamentoModel> agendamentos = agendamentoService.buscarTodos();
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{dataHora}/{palavra}")
    public ResponseEntity<List<AgendamentoModel>> getAgendamentosPorDataHoraEInstrucao(
            @PathVariable LocalDateTime dataHora,
            @PathVariable String palavra) {
        List<AgendamentoModel> agendamentos = agendamentoService
                .buscarTodosPorDataHoraEInstrucao(dataHora, palavra);
        
        return ResponseEntity.ok(agendamentos);
    }

    @PostMapping
    public ResponseEntity<?> createAgendamento(@RequestBody AgendamentoModel agendamento) {
        try {
            AgendamentoModel novoAgendamento = agendamentoService.criarAgendamento(agendamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } 
    }
}