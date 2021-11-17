package com.example.demo.Controllers;


import com.example.demo.entities.Budget;
import com.example.demo.entities.SuiviBudget;
import com.example.demo.repository.SuiviBudgetRepository;
import com.example.demo.service.SuiviBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiSuivibudget")
public class SuiviBudgetController {
    @Autowired
    SuiviBudgetService suiviBudgetService;
    @Autowired
    SuiviBudgetRepository suiviBudgetRepository;

    @PostMapping("/addSuiviBudget/{idbudget}/{idetat}")
    public SuiviBudget ajoutSuiviBudget(@RequestBody SuiviBudget sb,@PathVariable Long idbudget,@PathVariable Long idetat){
        return  suiviBudgetService.addsuiviBudget(sb,idbudget,idetat);
    }
    @PutMapping("/modifierSuiviBudget/{idcompte}/{idetat}")
    public  SuiviBudget modifierSuiviBudget( @RequestBody SuiviBudget sb ,@PathVariable  Long idcompte,@PathVariable Long idetat ){
        return suiviBudgetService.modifierSuiviBudget(sb,idcompte,idetat);
    }
    @GetMapping("/BudgetEnAttente/{idStructure}/{idetat}")
    public Collection<SuiviBudget> getBudgetEnAttenteStructure(@PathVariable Long idStructure,@PathVariable Long idetat){
        return suiviBudgetRepository.findSuiviBudgetByEtatBudget(idStructure,idetat);
    }
    @GetMapping("/BudgetBureauxEnAttente/{iddrp}/{idetat}")
    public Collection<SuiviBudget> getBudgetBureauEnAttente(@PathVariable Long iddrp,@PathVariable Long idetat){
        return suiviBudgetRepository.findSuiviBudgetStructureByEtatBudget(iddrp,idetat);
    }
    @GetMapping("/BudgetDrpEnAttente/{iddrp}")
    public Collection<SuiviBudget> getBudgetDrpEnAttente(@PathVariable Long iddrp){
        return suiviBudgetRepository.findBudgetbyDrp(iddrp);

    }

    @GetMapping("/BudgetEnAttenteDRP")
    public  Collection<SuiviBudget> getBudgetEnAttenteDrp(){
        return suiviBudgetRepository.findSuiviBudgetByDrp();
    }
    @PutMapping("/validerParDrp/{idbudget}")
    public SuiviBudget validerBudgetParDrp(@PathVariable Long idbudget){
        return  suiviBudgetRepository.validerBudgetParDrp(idbudget);
    }
    @PostMapping("/rejeterParDrp/{idbudget}")
    public SuiviBudget rejeterBudgetParDrp(@RequestBody SuiviBudget s,@PathVariable Long idbudget){
        return  suiviBudgetService.rejeterBudgetparDrp(s,idbudget);
    }
    @PostMapping("/validerParDcg/{idbudget}")
    public SuiviBudget validerBudgetParDcg(@RequestBody SuiviBudget s,@PathVariable Long idbudget){

        return  suiviBudgetService.validerBudgetparDcg(s,idbudget)  ;
    }
    @PutMapping("/validerParDcgF")
    public Budget validerBudgetParDcgFin(@RequestBody Budget b){
        return  suiviBudgetService.validerBudgetparDcgFin(b);
    }
    /*
     @PostMapping("/rejeterParDcg/{idbudget}")
    public SuiviBudget rejeterBudgetParDcg(@RequestBody SuiviBudget s,@PathVariable Long idbudget){
        return suiviBudgetService.rejeterBudgetparDcg(s,idbudget);
    } */

}
