package com.example.demo.service;

import com.example.demo.entities.Budget;
import com.example.demo.entities.SuiviBudget;

public interface SuiviBudgetService  {
    SuiviBudget addsuiviBudget(SuiviBudget sb, Long idbudget,Long idetat);
    SuiviBudget  modifierSuiviBudget(SuiviBudget sb , Long idbudget,Long idEtat);
    SuiviBudget  validerBudgetparDrp(Long idbudget);
    SuiviBudget  validerBudgetparDcg( SuiviBudget s,Long idbudget);
    Budget validerBudgetparDcgFin(Budget b);
    SuiviBudget rejeterBudgetparDrp(SuiviBudget s,Long idbudget);
    SuiviBudget rejeterBudgetparDcg(SuiviBudget s ,Long idbudget);

}
