/* eslint-disable @angular-eslint/no-empty-lifecycle-method */
import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Budget } from 'src/app/demo/model/budget';
import { LigneBudgetaire } from 'src/app/demo/model/ligneBudgetaire';
import { SuiviBudget } from 'src/app/demo/model/suiviBudget';
import { User } from 'src/app/demo/model/user';
import { AuthServiceService } from 'src/app/layout/service/auth-service.service';
import { BureauvalideService } from 'src/app/layout/service/bureauvalide.service';
@Component({
  selector: 'app-bureauvalide',
  templateUrl: './bureauvalide.component.html',
  styleUrls: ['./bureauvalide.component.scss'],
  providers: [MessageService]
})
export class BureauvalideComponent implements OnInit {
  budget: any;
  comptebudget:any;
  currentCompte:any;
  somme : number = 0;
  suiviSaved= new SuiviBudget();
  ligneSaved:any;
  budgets: number=0;
  idBudget: any;
  idEtat: number=0;
  idsuivi: any;
  donnee: any;
  infosUser:any=[];
  idroleuser: number=0;
  idstuser: number=0;
  compte:any = {}
  submitted: boolean = false;
  productDialog:boolean = false;
  nonvide:boolean=false;
  vide:boolean=false;
  newligne = new LigneBudgetaire();
  newbudget = new Budget();
  newSuivi = new SuiviBudget();
  // ligneSaved:any;

  constructor(private BureauvaliderService:BureauvalideService, private serviceAuth : AuthServiceService,private messageService:MessageService) { }

ngOnInit(): void {
    this.getInfosUsername();
   this.currentCompte=[];
  }

  getInfosUsername(){
    this.serviceAuth.infosUsername().subscribe(data => {
      this.infosUser = data;
      console.log(this.infosUser);
      //for (let c of this.infosUser) {
          this.idroleuser=this.infosUser.idrole;
          this.idstuser=this.infosUser.id;
        if (this.infosUser.idrole===2) {
          this.BureauvaliderService.monbur(this.idstuser,2).subscribe(data=>{
            this.donnee=data;
            if(this.donnee != ''){
              this.nonvide=true;

            }
             
            console.log(this.donnee,this.infosUser.id);
            for (let d of this.donnee) {
              console.log(d.budget.id)
              this.BureauvaliderService.consulterCompte(d.budget.id,2).subscribe(prod=>{
                this.currentCompte=prod;
                if(this.currentCompte != ''){
                  this.vide=true;
                }
               
                console.log(this.currentCompte);
              });
            }
          });
        }else if(this.infosUser.idrole===1){
          
          this.BureauvaliderService.monbur(this.infosUser.id,1).subscribe(data=>{
            this.donnee=data;
            console.log(this.donnee,this.infosUser.id);
            for (let d of this.donnee) {
              this.BureauvaliderService.consulterCompte(d.budget.id,1).subscribe(prod=>{
                this.currentCompte=prod;
                if(this.currentCompte != ''){
                  this.vide=true;
                }
                console.log(this.currentCompte);
              });
            }
          });
        }

          
     // }
    });
  }

  afficheCompte(d: any){
    console.log(d)
 
    this.BureauvaliderService.consulterCompte(d.budget.id,2).subscribe(prod=>{
      this.currentCompte=prod;
      console.log(this.currentCompte)
    });
    this.idsuivi=d.id
    console.log(this.idsuivi)

    this.submitted = false;
    this.productDialog = true;
  }
  

  update(){
    for (let c of this.currentCompte) {
    
      this.newligne.id=c.id;
      this.newligne.budget=c.budget.id;
      this.newligne.compteBudget=c.compteBudget.id;
      
      if (this.idroleuser===2) {
       this.newligne.montantProposeDrp = c.montantProposeDrp;
      }else if(this.idroleuser===1){
        this.newligne.montantProposeDrp=0;
        this.newligne.montantProposeBureau =c.montantProposeBureau;
      }
      this.newligne.version=1;
      // newligne.montantProposeDrp=c.montantProposeDrp;
          
    if (this.idroleuser===2) {
      this.somme=this.somme+c.montantProposeDrp;
    }else if(this.idroleuser===1){
      this.somme=this.somme+c.montantProposeBureau;
    }
      
      this.budgets=c.budget.montant_propose_bureau;
      this.idBudget=c.budget.id;
      console.log(c.montantProposeBureau,this.somme);
      this.BureauvaliderService.updateLigne(c).subscribe((data)=> {
        this.ligneSaved = data;
        this.messageService.add({severity: 'success',summary: 'Successful', detail: 'Montant  modifie avec succes',life: 3000,});
        console.log(this.ligneSaved)
      }); 
      
    }
    
    this.newbudget.id=this.idBudget;
    this.newbudget.montant_execute=0;
    
    if (this.idroleuser===2) {
      this.newbudget.montant_propose_drp=this.somme;
    }else if(this.idroleuser===1){
      this.newbudget.montant_propose_bureau=this.somme;
      this.newbudget.montant_propose_drp=0;
    }
    this.newbudget.version=1;
    this.newbudget.montant=0;
    this.BureauvaliderService.modifier(this.newbudget,this.idstuser).subscribe();
    
   
   

      if (this.idroleuser===2) {
        this.BureauvaliderService.saveSuivi(this.newSuivi,this.idBudget,3).subscribe(data => {
          this.suiviSaved = data;
        });
      } else if(this.idroleuser===1)
      {
        this.BureauvaliderService.saveSuivi(this.newSuivi,this.idBudget,2).subscribe(data => {
          this.suiviSaved = data;
        });
      }
    
      
      this.productDialog = false;
    
  }


  openNew() {
    this.compte = {};
    this.submitted = false;
    this.productDialog = true;
}
hideDialog() {
  this.productDialog = false;
  this.submitted = false;
}
  
}
