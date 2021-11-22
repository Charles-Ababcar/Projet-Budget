package com.example.demo.Controllers;


import com.example.demo.entities.Budget;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.LigneBudgetaireRepository;
import com.example.demo.repository.StructureRepository;
import com.example.demo.service.BudgetService;
import com.example.demo.service.LigneBudgetaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

@RequestMapping("/apiBudget")
public class BudgetController {
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    StructureRepository structureRepository;
    @Autowired
    BudgetService budgetService;
    @Autowired
    LigneBudgetaireRepository ligneBudgetaireRepository;
    @Autowired
    LigneBudgetaireService ligneBudgetaireService;

    @GetMapping("/budget/{idStructure}/{annee}")
    public Budget getBudgetByIdStructure(@PathVariable Long idStructure, @PathVariable Long annee){
        return budgetRepository.findBudgetByIdAndAnnee(idStructure,annee);
    }

    @GetMapping("/budgetDRP/{idDRP}/{annee}/{etat}")
    public Budget getBudgetDRPById(@PathVariable Long idDRP, @PathVariable Long annee, @PathVariable Long etat){
        return budgetRepository.findBudgetDRPByIdAndAnnee(idDRP,annee,etat);
    }
    @GetMapping("/annee/{idStructure}")
    public Collection getAnneeByIdStructure(@PathVariable Long idStructure){
        return budgetRepository.findAnneeByStructure(idStructure);
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sommebudget/{montant}/{sum}")
    public long getSommeBudget(@PathVariable long montant,@PathVariable long sum ){
        return budgetService.somme(montant,sum);
    }
    @GetMapping("/bureaux/{idDrp}/{annee}")
    public Collection<Budget> getBureaux(@PathVariable  long idDrp, @PathVariable Long annee){
        return  budgetRepository.findAllBureauByDRP(idDrp,annee);
    }
    @PostMapping("/addBudget/{idStructure}")
    public Budget ajoutBudget(@RequestBody Budget b, @PathVariable long idStructure){
        return budgetService.saveBudget(b,idStructure);
    }

    @PutMapping("/modifierBudget/{idStructure}")
    public Budget modifierBudget(@RequestBody Budget b, @RequestBody long idStructure){
        return budgetService.saveBudget(b,idStructure);
    }
    @GetMapping("/budget")
    public Collection<Budget> getAll(){
        return budgetRepository.findAll();
    }
    @GetMapping("/budgetAllDrp")
    public Collection<Budget> getAllDRP(){
        return budgetRepository.findBudgetAllDRP();
    }

}
