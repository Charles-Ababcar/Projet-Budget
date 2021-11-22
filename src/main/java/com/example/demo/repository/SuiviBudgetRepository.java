package com.example.demo.repository;

import com.example.demo.entities.SuiviBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface SuiviBudgetRepository extends JpaRepository<SuiviBudget,Long> {
    //Budget en attente de validation par la Structure
    @Query(value = "SELECT * FROM suivi_budget AS sb LEFT JOIN budget AS bd ON sb.id_budget= bd.id " +
            "LEFT JOIN structure AS s ON s.id=bd.id_structure" +
            " LEFT JOIN drp AS d ON d.id=s.id_drp" +
            " WHERE bd.id_structure=:idstructure AND annee=2021 " +
            " GROUP BY  bd.id HAVING MAX(sb.id_etat_budget)=:idetat " , nativeQuery = true)
    public Collection<SuiviBudget> findSuiviBudgetByEtatBudget(@Param("idstructure")long idStructure, @Param("idetat")long id);

    //Budget en attente de validation par la DRP
    @Query(value = "SELECT * FROM suivi_budget AS sb LEFT JOIN budget AS bd ON sb.id_budget= bd.id " +
            "LEFT JOIN structure AS s ON s.id=bd.id_structure" +
            " LEFT JOIN drp AS d ON d.id=s.id_drp" +
            " WHERE d.id=:iddrp AND annee=2021 AND s.bureau=1 " +
            " GROUP BY  bd.id HAVING MAX(sb.id_etat_budget)=:idetat " , nativeQuery = true)
    public Collection<SuiviBudget> findSuiviBudgetStructureByEtatBudget(@Param("iddrp")long iddrp, @Param("idetat")long id);

    //Budget des buraux en attente de validation par la DRP
    @Query(value = " SELECT * FROM suivi_budget AS sb LEFT JOIN budget AS bd ON sb.id_budget= bd.id " +
            " LEFT JOIN structure AS s ON s.id=bd.id_structure" +
            " WHERE s.id_drp=:idDrp AND annee=2021 AND sb.id_etat_budget=2  AND bureau=1  " , nativeQuery = true)
    public Collection<SuiviBudget> findBudgetbyDrp(@Param("idDrp")long iddrp);

    //Liste DRP avec un Budget en attente de validation par la DCG
    @Query(value = "SELECT * FROM suivi_budget AS sb LEFT JOIN budget AS bd ON sb.id_budget= bd.id " +
            " LEFT JOIN structure AS s ON s.id=bd.id_structure " +
            " LEFT JOIN drp AS d ON d.id=s.id_drp " +
            "WHERE annee=2021 AND sb.id_etat_budget=2 " +
            " GROUP BY d.id" , nativeQuery = true)
    public Collection<SuiviBudget> findSuiviBudgetByDrp();

    //Validation budget Par DRP
    @Query(value = "UPDATE suivi_budget SET id_etat_budget=1 WHERE id_budget=:idbudget" , nativeQuery = true)
    public SuiviBudget validerBudgetParDrp(@Param("idbudget")long id);

}
