package com.example.demo.service;

import com.example.demo.entities.Budget;

public interface BudgetService {
    public long somme(long montant,long sum);
    Budget saveBudget(Budget b,long idStructure);}
