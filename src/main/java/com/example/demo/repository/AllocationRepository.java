package com.example.demo.repository;

import com.example.demo.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface AllocationRepository extends JpaRepository<Allocation,Long> {
    //Liste DRP avec leur Budget
    @Query(value = " SELECT * FROM allocation " +
            "WHERE id_ligne_budgetaire=:idLigne" , nativeQuery = true)
    public Collection<Allocation> findAllocationByLignebudgetaire(@Param("idLigne")Long id);
}
