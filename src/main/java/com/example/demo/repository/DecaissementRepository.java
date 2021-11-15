package com.example.demo.repository;

import com.example.demo.entities.Decaissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface DecaissementRepository extends JpaRepository<Decaissement,Long> {
    //Dépenses en attente de validation par la DRP
    @Query(value =  " SELECT * FROM decaissement AS d " +
            " LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id " +
            "LEFT JOIN suivi AS s ON d.id=s.decaissement_id " +
            " LEFT JOIN etat AS e ON e.id=s.id_etat " +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id " +
            " LEFT JOIN budget AS b ON b.id=l.id_budget " +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE st.id_drp=:iddrp AND b.annee=2021 AND st.bureau=1" +
            " GROUP BY d.id HAVING MAX(s.id_etat)=:idetat  " , nativeQuery = true)
    public Collection<Decaissement> findAllDecaissementEnAttenteDrp(@Param("iddrp")Long iddrp,
                                                                    @Param("idetat")Long idetat);

    //Dépense selon l'état
    @Query(value = " SELECT * FROM decaissement AS d " +
            " LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id " +
            " LEFT JOIN suivi AS s ON d.id=s.decaissement_id " +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id " +
            " LEFT JOIN budget AS b ON b.id=l.id_budget " +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE d.id=:iddecaissement " +
            " GROUP BY d.id HAVING MAX(s.id_etat)=:idetat" , nativeQuery = true)
    public Collection<Decaissement> findDecaissementByEtat(@Param("iddecaissement")Long iddecaissement,
                                                           @Param("idetat")Long idetat);
    //Dépenses selon l'état et le compte
    @Query(value = " SELECT * FROM decaissement AS d " +
            " LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id " +
            " LEFT JOIN suivi AS s ON d.id=s.decaissement_id " +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id " +
            " LEFT JOIN budget AS b ON b.id=l.id_budget " +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE c.numero=:num  AND b.id=:idbudget " +
            " GROUP BY c.numero HAVING MAX(s.id_etat)=:idetat" , nativeQuery = true)
    public Collection<Decaissement> findDecaissementByCompteAndEtat(@Param("num")Long num,
                                                                    @Param("idbudget")Long idbudget,
                                                                    @Param("idetat")Long idetat);

    //Dépenses selon le budget et l'état
    @Query(value = " SELECT * FROM decaissement AS d " +
            " LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id " +
            " LEFT JOIN suivi AS s ON d.id=s.decaissement_id " +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id " +
            " LEFT JOIN budget AS b ON b.id=l.id_budget " +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE b.id_structure=:idstructure AND b.annee=2021 " +
            " GROUP BY c.numero HAVING MAX(s.id_etat)=:idetat" , nativeQuery = true)
    public Collection<Decaissement> findDecaissementByBudgetAndEtat(@Param("idstructure")Long idbudget,
                                                                    @Param("idetat")Long idetat);
    //Dépenses selon la structure et l'état
    @Query(value = " SELECT * FROM decaissement AS d " +
            " LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id " +
            "LEFT JOIN suivi AS s ON d.id=s.decaissement_id " +
            " LEFT JOIN etat AS e ON e.id=s.id_etat " +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id " +
            " LEFT JOIN budget AS b ON b.id=l.id_budget " +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE b.id_structure=:idstructure AND b.annee=2021" +
            " GROUP BY d.id HAVING MAX(s.id_etat)=:idetat  " , nativeQuery = true)
    public Collection<Decaissement> findDecaissementByStructureAndEtat(@Param("idstructure")Long idstructure,
                                                                       @Param("idetat")Long idetat);
    //Dépenses en attente de validation par la DCG
    @Query(value =  " SELECT * FROM decaissement AS d " +
            " LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id " +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id " +
            "LEFT JOIN budget AS b ON b.id=l.id_budget" +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " LEFT JOIN drp AS dr ON st.id_drp=dr.id " +
            "LEFT JOIN structure AS  st2 ON st2.id_drp=dr.id  AND st2.bureau=2 " +
            "WHERE b.annee=2021 " +
            " GROUP BY dr.id " , nativeQuery = true)
    public Collection<Decaissement> findAllDrpAttente();

    //Dépenses rejetées par la DRP
    @Query(value = "SELECT * FROM decaissement AS d LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id" +
            " LEFT JOIN suivi AS s ON d.id=s.decaissement_id" +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id" +
            " LEFT JOIN budget AS b ON b.id=l.id_budget" +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE c.bureau=1 AND s.id_etat=3" , nativeQuery = true)
    public Collection<Decaissement> findAllDecaissementRejeteesDRP();

    //Dépenses rejetées par la Dcg
    @Query(value = "SELECT * FROM decaissement AS d LEFT JOIN ligne_budgetaire AS l ON d.id_ligne_budgetaire=l.id" +
            " LEFT JOIN suivi AS s ON d.id=s.decaissement_id" +
            " LEFT JOIN compte_budget AS c ON l.id_compte_budget=c.id" +
            " LEFT JOIN budget AS b ON b.id=l.id_budget" +
            " LEFT JOIN structure AS  st ON st.id=b.id_structure" +
            " WHERE c.bureau=1 AND s.id_etat=5" , nativeQuery = true)
    public Collection<Decaissement> findAllDecaissementRejeteesDcg();

}
