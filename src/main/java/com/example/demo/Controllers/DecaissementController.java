package com.example.demo.Controllers;

import com.example.demo.entities.Decaissement;
import com.example.demo.entities.Suivi;
import com.example.demo.repository.DecaissementRepository;
import com.example.demo.service.DecaissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiDecaissement")
public class DecaissementController {
    @Autowired
    DecaissementService decaissementService;
    @Autowired
    DecaissementRepository decaissementRepository;

    @PostMapping(value = "/addDecaissement/{idLigne}/{montant}")

    public Decaissement ajoutDecaissement(Decaissement d, @PathVariable Long idLigne, @PathVariable Long  montant,
                                          @RequestParam (name = "image",required = false) MultipartFile multipartFile) throws IOException{
        if(multipartFile != null){
            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            d.setJustificatif(filename);
            Decaissement saveDbDecaissement = decaissementService.saveDecaissement(d,idLigne,montant);
            String uploaDir="Decaissements-justifications/"+ saveDbDecaissement.getId();

            FileUploadUtil.saveFile(uploaDir,filename,multipartFile);

        }else {
            decaissementService.saveDecaissement(d,idLigne,montant);
        }

        return d;

    }

    @PostMapping("/addSuivi/{idDecais}/{idEtat}")
    public Suivi addSuivi(Suivi s , @PathVariable Long idDecais, @PathVariable Long idEtat){
        return  decaissementService.saveSuivi(s,idDecais,idEtat);

    }

    //Depenses en Attente
    @GetMapping("/depenses/{iddecaissement}/{idetat}")
    public Collection<Decaissement> getDepenses(@PathVariable  Long  iddecaissement, @PathVariable Long idetat){
        return  decaissementRepository.findDecaissementByEtat(iddecaissement,idetat);
    }

    //Depenses
    @GetMapping("/depensesByCompte/{num}/{idbudget}/{idetat}")
    public Collection<Decaissement> getDepensesByCompte(@PathVariable Long num, @PathVariable Long idbudget, @PathVariable Long idetat){
        return decaissementRepository.findDecaissementByCompteAndEtat(num,idbudget,idetat);
    }
    //Depenses en Attente selon la structure
    @GetMapping("/depensesAttentesStructure/{idStructure}/{idetat}")
    public Collection<Decaissement> getDepenseEnAttente(@PathVariable Long idStructure, @PathVariable Long idetat){
        return decaissementRepository.findDecaissementByStructureAndEtat(idStructure,idetat);
    }

    //Depenses en Attente pour une DRP X
    @GetMapping("/DepensesEnAttenteDrp/{iddrp}/{idetat}")
    public Collection<Decaissement> getDepensesEnAttenteDCG(@PathVariable Long iddrp, @PathVariable Long idetat) {
        return decaissementRepository.findAllDecaissementEnAttenteDrp(iddrp,idetat);
    }

    //DRP en Attente pour une DCG
    @GetMapping("/DrpEnAttente")
    public Collection<Decaissement> getDepensesEnAttenteDCG() {

        return decaissementRepository.findAllDrpAttente();
    }
    @GetMapping("/DepensesRejeteesDRP")
    public Collection<Decaissement> getDepensesRejeteesDRP(){
        return decaissementRepository.findAllDecaissementRejeteesDRP();
    }
    @GetMapping("/DepensesRejeteesDCG")
    public Collection<Decaissement> getDepensesRejeteesDCG(){
        return decaissementRepository.findAllDecaissementRejeteesDcg();
    }
    @PutMapping("/validerDecaissement/{idbudget}/{idligne}/{montant}")
    public void validerDecaissement(@PathVariable Long idbudget,@PathVariable Long idligne,@PathVariable Long montant) {
        decaissementService.validerDecaissement(idbudget,idligne,montant);
    }

}


