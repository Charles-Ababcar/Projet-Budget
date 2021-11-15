package com.example.demo.service;

import com.example.demo.entities.Allocation;
import com.example.demo.entities.LigneBudgetaire;
import com.example.demo.repository.AllocationRepository;
import com.example.demo.repository.LigneBudgetaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    AllocationRepository allocationRepository;
    @Autowired
    LigneBudgetaireRepository ligneBudgetaireRepository;
    @Override
    public Allocation saveAllocation(Allocation a, long idLigneBudgetaire) {
        Optional<LigneBudgetaire> l = ligneBudgetaireRepository.findById(idLigneBudgetaire);
        a.setLignebudgetaire(l.get());
        Date date = new Date();
        a.setDate(date);
        return allocationRepository.save(a);
    }
}
