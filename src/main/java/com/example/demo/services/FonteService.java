package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.FonteModel;
import com.example.demo.repository.FonteRespository;



@Service
public class FonteService {
    @Autowired
    private FonteRespository fonteRepository;

    public FonteModel cadastrarFonte(FonteModel fonte){
        if (fonte.getDescritivo().isEmpty() || fonte.getDescritivo().length() < 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O descritivo deve ter pelo menos 4 caracteres");
        }
        if (fonte.getPotenciaReal() != null && fonte.getPotenciaReal() > fonte.getPotenciaNominal()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A potencia real n~so pode ser maior que a potencia nominal");
        }
        return this.fonteRepository.save(fonte);
    }

    public List<FonteModel> listarTodasFontes(){
        List<FonteModel> listaFonteModel = fonteRepository.findAll();
        return listaFonteModel;
    }

    public List<FonteModel> buscarPotencia(Integer potenciaMinima, LocalDate dataMaxima){
        return fonteRepository.buscaPotenciaRealGreaterThanAndDataLancamentoLessThan(potenciaMinima, dataMaxima);
    }

}
