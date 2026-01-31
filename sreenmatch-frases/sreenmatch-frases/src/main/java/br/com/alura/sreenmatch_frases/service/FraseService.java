package br.com.alura.sreenmatch_frases.service;


import br.com.alura.sreenmatch_frases.DTO.FraseDTO;
import br.com.alura.sreenmatch_frases.model.Frase;
import br.com.alura.sreenmatch_frases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    FraseRepository repositorio;


    public FraseDTO obterFraseAleatoria() {
        Frase frase = repositorio.buscaFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }
}
