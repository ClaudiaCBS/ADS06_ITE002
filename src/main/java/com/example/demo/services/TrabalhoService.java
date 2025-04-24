package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TrabalhoModel;
import com.example.demo.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public TrabalhoModel cadastrarTrabalho(TrabalhoModel trabalho){
        if (trabalho.getTitulo().isEmpty() || trabalho.getTitulo() == null) {
            throw new IllegalArgumentException("O título está vazio!");
        }
        if (trabalho.getGrupo().isEmpty() || trabalho.getGrupo() == null) {
            throw new IllegalArgumentException("O grupo está vazio!");
        }
        if (trabalho.getDataHoraEntrega() == null) {

            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        return this.trabalhoRepository.save(trabalho);
    }

    public List<TrabalhoModel> listarTodosTrabalhos(){
        List<TrabalhoModel> listaTrabalhoModel = trabalhoRepository.findAll();
        return listaTrabalhoModel;
    }

    public List<TrabalhoModel> listarPalavraNotaMinima(String palavra, Integer notaMinima){
        List<TrabalhoModel> listaTrabalhoModel = trabalhoRepository.buscarTrabalhoPorPalavraNotaSuperior(notaMinima, palavra);
        return listaTrabalhoModel;
    }

}
