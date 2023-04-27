package com.example.demo.Controllers;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class DgUserController {

    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

    final String BASE_URL = "http://10.14.14.232:8084/module-principal";
    //final String BASE_URL =  "http://10.6.4.44:8085/module-principal/";
    //final String BASE_URL = new String("http://localhost:8081") ;

    @GetMapping(value = "/user/email/{email}")
    public Object getUserByEmail(@PathVariable String email) {
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_User/email/"+email, Object.class);
    }

    @GetMapping(value = "/user/{id}")
    public Object getUserById(@PathVariable int id){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_User/"+id, Object.class);
    }

    @GetMapping(value = "/caisse/structure/{structureId}")
    public Object getCaisseByStructureId(@PathVariable Long structureId){
        return  keycloakRestTemplate.getForObject(BASE_URL+"/dg_Caisse/structure/"+structureId, Object.class);
    }

    @GetMapping(value = "/caisse/{id}")
    public Object getCaisseById(@PathVariable Long id){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Caisse/"+id, Object.class);
    }

    @GetMapping(value = "/bureau/{idBureau}")
    public Object getBureauById(@PathVariable Long idBureau){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Structure/"+idBureau, Object.class);
    }

    @GetMapping(value = "/alldrp")
    public Object getAllDrp(){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Drp", Object.class);
    }

    @GetMapping(value = "/structure/{drpId}")
    public Object getStructureByIdDrp(@PathVariable int drpId){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Structure/drp/"+drpId, Object.class);
    }

    @GetMapping(value = "/drp/{structureId}")
    public Object getStructureById(@PathVariable int structureId){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Structure/"+structureId, Object.class);
    }

    @GetMapping(value = "/soldeCaisse/{caisseId}")
    public String soldeCaisse(@PathVariable int caisseId){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Caisse/getNumeraire/"+caisseId, String.class);
    }

    @GetMapping(value = "/verifierSoldeCaisse/{caisseId}/{montant}")
    public boolean verificationSoldeCaisse(@PathVariable int caisseId, @PathVariable double montant){
        return keycloakRestTemplate.getForObject(BASE_URL+"/dg_Caisse/verifierSoldeCaisse/"+caisseId+"/"+montant, boolean.class);
    }


    @PutMapping(value = "/augnum/{caisseId}/{montant}")
    public void augmentationSoldeCaisse(@PathVariable int caisseId, @PathVariable double montant){
       keycloakRestTemplate.put(BASE_URL+"/dg_Caisse/augnum/"+caisseId+"/"+montant, null);
    }

    @PutMapping(value = "/dimnum/{caisseId}/{montant}")
    public void diminutionSoldeCaisse(@PathVariable int caisseId, @PathVariable double montant){
         keycloakRestTemplate.put(BASE_URL+"/dg_Caisse/dimnum/"+caisseId+"/"+montant, null);
    }
}
