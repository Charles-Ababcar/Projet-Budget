package com.example.demo.service;

import com.example.demo.entities.Budget;
import com.example.demo.entities.Structure;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.EtatBudgetRepository;
import com.example.demo.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    StructureRepository structureRepository;
    @Autowired
    EtatBudgetRepository etatBudgetRepository;
    @Override
    public long somme(long montant, long sum) {
        sum= sum +montant;
        return sum;
    }

    @Override
    public Budget saveBudget(Budget b, long idStructure) {
        Optional<Structure> st=structureRepository.findById(idStructure);
        b.setStructure(st.get());
        int annee= Calendar.getInstance().get(Calendar.YEAR);
        b.setAnnee(annee);
        return budgetRepository.save(b);
    }
}
