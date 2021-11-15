package com.example.demo.Controllers;

import com.example.demo.entities.LigneBudgetaire;
import com.example.demo.repository.LigneBudgetaireRepository;
import com.example.demo.service.LigneBudgetaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiLigneBudget")
public class LigneBudgetaireController {
    @Autowired
    LigneBudgetaireRepository ligneBudgetaireRepository;
    @Autowired
    LigneBudgetaireService ligneBudgetaireService;

    @PostMapping("/addLigneBudget/{idbudget}/{idcompte}")
    public LigneBudgetaire ajoutLigneBudget(@RequestBody LigneBudgetaire l,@PathVariable long idbudget,@PathVariable long idcompte){
        return ligneBudgetaireService.saveLigneBudgetaire(l,idbudget,idcompte);
    }
    @PutMapping("/modifierLigneBudget/{idbudget}/{idcompte}")
    public LigneBudgetaire modifierLigneBudget(@RequestBody LigneBudgetaire l,@PathVariable long idbudget,@PathVariable long idcompte){
        return ligneBudgetaireService.saveLigneBudgetaire(l,idbudget,idcompte);
    }
    @GetMapping("/budgetParCompte/{idbudget}/{idetat}")
    public Collection<LigneBudgetaire> lignes(@PathVariable Long idbudget,@PathVariable Long idetat){
        return ligneBudgetaireRepository.findAllBudgetByCompteBudget(idbudget,idetat);
    }

    @GetMapping("/budgetUnCompte/{idbudget}/{num}/{idetat}")
    public Collection<LigneBudgetaire> lignes(@PathVariable Long idbudget,@PathVariable Long num,@PathVariable Long idetat){
        return ligneBudgetaireRepository.findBudgetByCompteBudget(idbudget,num,idetat);
    }

}
