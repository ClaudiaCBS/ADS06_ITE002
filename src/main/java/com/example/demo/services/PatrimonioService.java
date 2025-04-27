package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.PatrimonioModel;
import com.example.demo.repository.PatrimonioRepository;

@Service
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository repository;

    public PatrimonioModel cadastrarPatrimonio(PatrimonioModel patrimonio) {
        if (patrimonio.getDataAquisicao() == null) {
            patrimonio.setDataAquisicao(LocalDate.now());
        }
        if (patrimonio.getValor() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "valor não pode ser negativo");
        }
        if (!patrimonio.getTipo().equalsIgnoreCase("BI") && !patrimonio.getTipo().equalsIgnoreCase("BM") && !patrimonio.getTipo().equalsIgnoreCase("BF")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "o tipo enviado é inválido, use apenas um desses tipos: BF, BM, BI");
        }
        
        return repository.save(patrimonio);
    }

    public List<PatrimonioModel> listarPatrimonio(){
        return repository.findAll();
    }

    public List<PatrimonioModel> listarPorDataAquisicaoEValor(LocalDate dataAquisicao, Float valor ) {
        return repository.findByDataAquisicaoGreaterThanAndValorLessThan(dataAquisicao, valor);
    }
}
