package com.example.demo.repository;

import com.example.demo.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface BudgetRepository extends JpaRepository<Budget,Long> {
    //Budget d'un bureau Y et d'une année X
    @Query(value = "SELECT * FROM budget AS bd, structure AS s WHERE bd.id_structure=:idstructure AND bd.annee=:annee AND s.id=bd.id_structure " , nativeQuery = true)
    public List<Budget> findAllBudgetByIdAndAnnee(@Param("idstructure")Long id, @Param("annee")Long annee);

    @Query(value = "SELECT * FROM budget AS bd" +
            " LEFT JOIN structure AS s ON s.id=bd.id_structure " +
            " LEFT JOIN drp AS d ON d.id=s.id_drp" +
            " LEFT JOIN suivi_budget AS sb ON sb.id_budget= bd.id " +
            " WHERE annee=:annee AND s.bureau=2 AND sb.id_etat_budget=:etat AND s.id_drp=:iddrp " , nativeQuery = true)
    public Budget findBudgetDRPByIdAndAnnee(@Param("iddrp")Long id, @Param("annee")Long annee, @Param("etat")Long etat);


    @Query(value = " SELECT * FROM budget " +
            " WHERE id_structure=:idstructure " , nativeQuery = true)
    public Collection<Budget> findAnneeByStructure(@Param("idstructure")Long id);

    //Liste bureau et budget d'un DRP X
    @Query(value = " SELECT * FROM budget AS bd " +
            " LEFT JOIN structure AS s ON s.id=bd.id_structure " +
            " LEFT JOIN suivi_budget AS sb ON bd.id=sb.id_budget  " +
            " WHERE annee=:annee AND s.id_drp=:id AND bureau=1 AND sb.id_etat_budget=4 ", nativeQuery = true)
    public Collection<Budget> findAllBureauByDRP(@Param("id")long id, @Param("annee")Long annee);

    //Liste DRP avec leur Budget
    @Query(value = "SELECT * FROM budget AS bd " +
            " LEFT JOIN structure AS s ON s.id=bd.id_structure " +
            " LEFT JOIN drp AS d ON d.id=s.id_drp" +
            " LEFT JOIN structure AS  st2 ON st2.id_drp=d.id  AND st2.bureau=2 " +
            " LEFT JOIN suivi_budget AS sb ON sb.id_budget= bd.id " +
            " WHERE annee=2021" +
            " GROUP BY d.id " , nativeQuery = true)
    public Collection<Budget> findBudgetAllDRP();

}


