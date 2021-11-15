package com.example.demo.repository;

import com.example.demo.entities.EtatBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtatBudgetRepository extends JpaRepository<EtatBudget,Long> {
}
