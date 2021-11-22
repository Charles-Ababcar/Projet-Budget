package com.example.demo.service;

import com.example.demo.entities.Decaissement;
import com.example.demo.entities.Suivi;

public interface DecaissementService {
    Decaissement saveDecaissement(Decaissement d, Long idLigneBudgetaire, Long montant);
    Suivi saveSuivi(Suivi s, Long idDecaissement, Long idEtat);
    void validerDecaissement(Long idBudget,Long idLigneBudgetaire,Long montant);
}
