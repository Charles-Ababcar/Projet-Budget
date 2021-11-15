package com.example.demo.repository;

import com.example.demo.entities.LigneBudgetaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RepositoryRestResource
public interface LigneBudgetaireRepository extends JpaRepository<LigneBudgetaire,Long> {
    //Budget demandé pour chaque compte
    @Query(value = "SELECT * FROM ligne_budgetaire AS l " +
            " LEFT JOIN suivi_budget AS s ON s.id_budget=l.id_budget " +
            "LEFT JOIN compte_budget AS c ON c.id=l.id_compte_budget " +
            " WHERE l.id_budget =:idbudget " +
            " GROUP BY l.id HAVING MAX(s.id_etat_budget)=:idetat ",nativeQuery = true)
    public Collection<LigneBudgetaire> findAllBudgetByCompteBudget(@Param("idbudget")Long id,
                                                                   @Param("idetat")Long idetat);
    //Budget demandé pour un compte
    @Query(value = "SELECT * FROM ligne_budgetaire AS l " +
            " LEFT JOIN suivi_budget AS s ON s.id_budget=l.id_budget " +
            "LEFT JOIN compte_budget AS c ON c.id=l.id_compte_budget " +
            " WHERE l.id_budget =:idbudget AND c.numero=:num " +
            " GROUP BY l.id HAVING MAX(s.id_etat_budget)=:idetat ",nativeQuery = true)
    public Collection<LigneBudgetaire> findBudgetByCompteBudget(@Param("idbudget")Long id,
                                                                @Param("num")Long num,
                                                                @Param("idetat")Long idetat);

    //Modifier Ligne budgetaire pour un décaissement
    @Transactional
    @Modifying
    @Query(value = "UPDATE ligne_budgetaire SET montant_execute=:montant WHERE id=:idligne" , nativeQuery = true)
    public void decaisserLigne(@Param("idligne")Long id,@Param("montant")Long montant);

    //Modifier Ligne budgetaire pour un remaniement
    @Transactional
    @Modifying
    @Query(value = "UPDATE ligne_budgetaire SET montant=:montant WHERE id=:idligne" , nativeQuery = true)
    public void RemanierLigne(@Param("idligne")Long id,@Param("montant")Long montant);
}
