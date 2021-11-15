package com.example.demo.service;

import com.example.demo.entities.CompteBudget;

import java.util.Collection;

public interface CompteBudgetService {
    Collection<CompteBudget> getCompteBudget();
    Collection<CompteBudget> getAllCompteBudget();
}
