package com.example.demo.service;

import com.example.demo.entities.Budget;
import com.example.demo.entities.CompteBudget;
import com.example.demo.entities.LigneBudgetaire;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.CompteBudgetRepository;
import com.example.demo.repository.LigneBudgetaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LigneBudgetaireServiceImp implements LigneBudgetaireService {
    @Autowired
    LigneBudgetaireRepository ligneBudgetaireRepository;
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    CompteBudgetRepository compteBudgetRepository;
    @Override
    public LigneBudgetaire saveLigneBudgetaire(LigneBudgetaire l, Long idBudget, Long idcompte) {
        Optional<Budget> b= budgetRepository.findById((Long) idBudget);
        l.setBudget(b.get());
        Optional<CompteBudget> c=compteBudgetRepository.findById((Long) idcompte);
        l.setCompteBudget(c.get());
        return ligneBudgetaireRepository.save(l);
    }
}
