package com.example.demo.service;

import com.example.demo.entities.LigneBudgetaire;

public interface LigneBudgetaireService {
    LigneBudgetaire saveLigneBudgetaire(LigneBudgetaire l,Long idBudget,Long idcompte);
}
