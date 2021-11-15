package com.example.demo.service;

import com.example.demo.entities.CompteBudget;
import com.example.demo.repository.CompteBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompteBudgetServiceImp implements CompteBudgetService {
    @Autowired
    CompteBudgetRepository compteBudgetRepository;
    @Override
    public Collection<CompteBudget> getCompteBudget() {

        return compteBudgetRepository.findAllByBureau();
    }

    @Override
    public Collection<CompteBudget> getAllCompteBudget() {
        return compteBudgetRepository.findAll();
    }
}
