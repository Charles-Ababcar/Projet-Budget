package com.example.demo.Controllers;


import com.example.demo.entities.CompteBudget;
import com.example.demo.entities.LigneBudgetaire;
import com.example.demo.repository.CompteBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiCompteBudget")
public class CompteBudgetController {
    @Autowired
    CompteBudgetRepository compteBudgetRepository;

    @GetMapping("/listeCompteparBureau")
    public Collection<CompteBudget> getCompte(){
        return  compteBudgetRepository.findAllByBureau();
    }
    @GetMapping("/listeCompteparStructure/{bureau}/{bureau1}")
    public  Collection<CompteBudget> getCompteStructure(@PathVariable Long bureau, @PathVariable Long bureau1){
        return compteBudgetRepository.findAllCompteByBureau(bureau,bureau1);
    }
    //Infos d'un compte d'une structure
    @GetMapping("/infosCompteparStructure/{num}/{idSt}")
    public Collection<LigneBudgetaire> getInfosCompteStructure(@PathVariable Long num, @PathVariable Long idSt){
        return  compteBudgetRepository.findCompteByBureau(num,idSt);
    }

    @GetMapping("/listeCompteBudget")
    public Collection<CompteBudget> getAllCompte(){
        return  compteBudgetRepository.findAll();
    }


}
