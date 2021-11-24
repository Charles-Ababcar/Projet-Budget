package com.example.demo.repository;

import com.example.demo.entities.CompteBudget;
import com.example.demo.entities.LigneBudgetaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface CompteBudgetRepository extends JpaRepository<CompteBudget,Long> {
    //Liste des comptes avec budget pour une structure X
    @Query(value = "SELECT * FROM compte_budget AS c LEFT JOIN ligne_budgetaire AS l ON c.id=l.id_compte_budget" +
            " LEFT JOIN suivi_budget AS s ON s.id_budget=l.id_budget" +
            " WHERE c.bureau=1 GROUP BY c.numero", nativeQuery = true)
    public Collection<CompteBudget> findAllByBureau();

    //Liste des comptes  pour une structure X(DRP ou Bureau)
    @Query(value = "SELECT * FROM compte_budget WHERE bureau=:bureau OR bureau=:bureau1", nativeQuery = true)
    public Collection<CompteBudget> findAllCompteByBureau(@Param("bureau")Long bureau, @Param("bureau1")Long bureau1);

    //Infos d'un compte d'une structure
    @Query(value = "SELECT * FROM ligne_budgetaire AS l " +
            " LEFT JOIN  compte_budget AS c ON c.id=l.id_compte_budget " +
            " LEFT JOIN budget AS b ON b.id=l.id_budget " +
            " LEFT JOIN suivi_budget AS s ON s.id_budget=l.id_budget " +
            " LEFT JOIN structure AS st ON st.id=b.id_structure " +
            " WHERE c.numero=:num AND st.id=:idst  " +
            " GROUP BY c.numero HAVING MAX(s.id_etat_budget)=4", nativeQuery = true)
    public Collection<LigneBudgetaire>  findCompteByBureau(@Param("num")Long num, @Param("idst")Long idst);
}
