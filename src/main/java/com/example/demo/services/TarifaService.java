package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.TarifaModel;
import com.example.demo.repository.TarifaRepository;

@Service
public class TarifaService {
    @Autowired
    private TarifaRepository tarifaRepository;

    public TarifaModel cadastrarTarifa(TarifaModel tarifa){
        if (tarifa.getDataInicio() == null) {
            tarifa.setDataInicio(LocalDate.now());
        }
        if (tarifa.getAliquota() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A alíquota deve ser superior a zero");
        }
        if (tarifa.getDataTermino() != null && 
            tarifa.getDataTermino().isBefore(tarifa.getDataInicio())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data de término não pode começar antes da data inicio, deve ser posterior a data inicio");
        }

        return this.tarifaRepository.save(tarifa);
    }

    public List<TarifaModel> listarTodasTarifas(){
        List<TarifaModel> listaTarifaModel = tarifaRepository.findAll();
        return listaTarifaModel;
    }

    public List<TarifaModel> buscarPorNomeDataAnterior(String nome, LocalDate data){
        return tarifaRepository.findByNomeAndDataInicioLessThan(nome, data);
    }

}
