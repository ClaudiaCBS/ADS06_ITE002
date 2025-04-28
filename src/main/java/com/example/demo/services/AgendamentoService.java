package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.repository.AgendamentoRepository;
import com.example.demo.models.AgendamentoModel;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository repository;

    public List<AgendamentoModel> buscarTodos(){
        return repository.findAll();
    }

    public List<AgendamentoModel> buscarTodosPorDataHoraEInstrucao(LocalDateTime dataHora, String palavra){
        return repository.findByDataHoraInicioGreaterThanAndInstrucoesContaining(dataHora, palavra);
    }

    public AgendamentoModel criarAgendamento(AgendamentoModel agendamento) {
        if (agendamento.getDataHoraInicio() == null) {
            agendamento.setDataHoraInicio(LocalDateTime.now().plusDays(1));
        }

        if (agendamento.getDuracao() != null) {
            if (agendamento.getDuracao() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O tempo de duração não pode ser negativo");
            }
        }

        if (agendamento.getValor() != null) {
            if (agendamento.getValor() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor não pode ser negativo");
            }
        }
        
        return repository.save(agendamento);
    }
}
