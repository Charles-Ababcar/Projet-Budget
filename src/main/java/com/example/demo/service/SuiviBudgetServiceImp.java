package com.example.demo.service;

import com.example.demo.entities.Budget;
import com.example.demo.entities.EtatBudget;
import com.example.demo.entities.SuiviBudget;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.EtatBudgetRepository;
import com.example.demo.repository.SuiviBudgetRepository;
import com.example.demo.repository.SuiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


@Service
@Transactional
public class SuiviBudgetServiceImp implements SuiviBudgetService {
    @Autowired
    SuiviBudgetRepository suiviBudgetRepository;
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    EtatBudgetRepository etatBudgetRepository;


    @Override
    public SuiviBudget addsuiviBudget(SuiviBudget sb, Long idbudget, Long idetat) {
        Optional<Budget> b =budgetRepository.findById(idbudget);
        sb.setBudget(b.get());
        Optional<EtatBudget> eb=etatBudgetRepository.findById(idetat);
        sb.setEtatBudget(eb.get());
        Date date = new Date();
        sb.setDate(date);
        return suiviBudgetRepository.save(sb);

    }

    @Override
    public SuiviBudget modifierSuiviBudget(SuiviBudget sb,Long idetat, Long idbudget) {
        System.out.print(sb);
        /*
        Optional<Budget> b =budgetRepository.findById(idbudget);
        sb.setBudget(b.get());
        Optional<EtatBudget> eb=etatBudgetRepository.findById(idetat);
        sb.setEtatBudget(eb.get());
        Date date = new Date();
        sb.setDate(date);
        return suiviBudgetRepository.save(sb);
         */

        SuiviBudget suivi=suiviBudgetRepository.findByBudget_Id(idbudget);

        suivi.setEtatBudget(sb.getEtatBudget());
        return suiviBudgetRepository.save(suivi);





    }

    @Override
    public SuiviBudget validerBudgetparDrp(Long idbudget) {

        return suiviBudgetRepository.validerBudgetParDrp(idbudget);
    }

    @Override
    public SuiviBudget validerBudgetparDcg(SuiviBudget s, Long idbudget) {
        Optional<Budget> b= budgetRepository.findById((long)idbudget);
        s.setBudget(b.get());
        Optional<EtatBudget> e= etatBudgetRepository.findById((long) 3);
        s.setEtatBudget(e.get());
        Date date= new Date();
        s.setDate(date);
        return suiviBudgetRepository.save(s);
    }

    @Override
    public Budget validerBudgetparDcgFin(Budget b) {
        return budgetRepository.save(b);
    }

    @Override
    public SuiviBudget rejeterBudgetparDrp(SuiviBudget s, Long idbudget) {
        Optional<Budget> b = budgetRepository.findById((long)idbudget);
        s.setBudget(b.get());
        Optional<EtatBudget> eb = etatBudgetRepository.findById((long) 2);
        s.setEtatBudget(eb.get());
        Date date = new Date();
        s.setDate(date);
         suiviBudgetRepository.save(s);
        return s;
    }

    @Override
    public SuiviBudget rejeterBudgetparDcg(SuiviBudget s, Long idbudget) {
        Optional<Budget> b = budgetRepository.findById((long) idbudget);
        s.setBudget(b.get());
        Optional<EtatBudget> eb = etatBudgetRepository.findById((long) 4);
        s.setEtatBudget(eb.get());
         Date date = new Date();
         s.setDate(date);
         suiviBudgetRepository.save(s);
        return s;
    }
}
