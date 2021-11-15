package com.example.demo.service;

import com.example.demo.entities.Decaissement;
import com.example.demo.entities.LigneBudgetaire;
import com.example.demo.entities.Suivi;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DecaissementServiceImp implements DecaissementService {
    @Autowired
    DecaissementRepository decaissementRepository;
    @Autowired
    LigneBudgetaireRepository ligneBudgetaireRepository;
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    EtatRepository etatRepository;
    @Autowired
    SuiviRepository suiviRepository;

    @Override
    public Decaissement saveDecaissement(Decaissement d, Long idLigneBudgetaire, Long montant) {
        Optional<LigneBudgetaire> l = ligneBudgetaireRepository.findById(idLigneBudgetaire);
        d.setLigneBudgetaires(l.get());
        Date date= new Date();
        d.setDate(date);
        Long idcompte = l.get().getCompteBudget().getId();
        Double retenue= 0.0;
        Double tva=0.0;
        if (idcompte >=7 && montant>25000)
        {
            retenue=montant+0.5;
            tva =montant+0.18;
        }
        d.setRetenue(retenue);
        d.setTVAPaye(tva);
        return decaissementRepository.save(d);
    }

    @Override
    public Suivi saveSuivi(Suivi s, Long idDecaissement, Long idEtat)
    {
        return null;
    }

    @Override
    public void validerDecaissement(Long idBudget, Long idLigneBudgetaire, Long montant) {

    }
}
