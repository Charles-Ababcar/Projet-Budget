import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Product } from 'src/app/demo/api/product';
import { Budget } from 'src/app/demo/model/budget';
import { LigneBudgetaire } from 'src/app/demo/model/ligneBudgetaire';
import { SuiviBudget } from 'src/app/demo/model/suiviBudget';
import { AuthServiceService } from 'src/app/layout/service/auth-service.service';
import { BudgetValiderService } from 'src/app/layout/service/budget-valider.service';

@Component({
  selector: 'app-budget-valider',
  templateUrl: './budget-valider.component.html',
  styleUrls: ['./budget-valider.component.scss'],
  providers: [MessageService]
})
export class BudgetValiderComponent implements OnInit {
  infosUser:any=[];
  products: Product[] = [];
  product: Product = {};
  idrole: number=0;
  idstructure: number=0;
  iddrp:number=0;
  budget : any ={}
  currentCompte:any;
  listbudget:any=[];
  listCompte:any=[]
  bud: any
  idsuivi:number=0
  compte:any = {}
  submitted: boolean = false;
  productDialog:boolean = false;
   newligne = new LigneBudgetaire();
  newbudget = new Budget();
  newSuivi = new SuiviBudget();
   somme : number = 0;
   budgets: number=0;
   idBudget: any;
  ligneSaved: any;
  suiviSaved:any;
  budgetsave:any;
  c:any
id:any;
nonvide:boolean=false;
  constructor( private serviceAuth:AuthServiceService, private budgetvalideService:BudgetValiderService, private messageService:MessageService) { }

  // eslint-disable-next-line @angular-eslint/no-empty-lifecycle-method
  ngOnInit(): void {
   this.getInfosUsername();
   
   
  }
  getInfosUsername(){
    this.serviceAuth.infosUsername().subscribe(
        (data) => {
            this.infosUser = data;
            console.log(this.infosUser);
              this.idrole=this.infosUser.idrole;
              this.idstructure=this.infosUser.id;
              this.iddrp=this.infosUser.structure.drp.id;
            
              console.log(this.idrole,this.idstructure, this.iddrp);
              this.budgetvalideService.ListeBureau(this.iddrp,2).subscribe((burs)=>{
                this.budget=burs;
                console.log(this.budget); 
                 
                    if(this.budget !=''){
                      this.nonvide=true;

                    }else
                    this.nonvide=false;
                           
            }); 
              
              console.log(this.listbudget);   
            
        })
    }

    afficheCompte(bud: any){
      console.log(bud)
   
      this.budgetvalideService.consulterCompte(bud.budget.id,2).subscribe(prod=>{
        this.currentCompte=prod;
        console.log(this.currentCompte)
      });
      this.idsuivi=bud.id
      console.log(this.idsuivi)

      this.submitted = false;
      this.productDialog = true;
    }
    


  update(){
   
  for (let cp of this.currentCompte) {
    console.log(cp)
  
    this.newligne.id=cp.id;

    this.newligne.budget =cp.budget;
    //console.log(this.newligne.budget?.id)
    this.newligne.compteBudget=cp.compteBudget.id;
   // console.log( this.newligne.compteBudget?.id)
    this.newligne.montantProposeBureau=cp.montantProposeBureau;
    console.log( this.newligne.montantProposeBureau)
    this.newligne.montantProposeDrp=cp.montantProposeDrp;
    console.log( this.newligne.montantProposeDrp)
    this.somme=this.somme+cp.budget.montant_propose_drp;
    this.budgets=cp.budget.montant_propose_bureau;
    this.idBudget=cp.budget.id;
    this.idstructure=cp.budget.structure.id;
 console.log( this.budgets, this.idBudget,this.somme,this.idstructure)
    this.budgetvalideService.updateLigne(cp).subscribe((data)=> {
       this.ligneSaved = data;
       this.messageService.add({severity: 'success',summary: 'Successful', detail: 'Montant  modifie avec succes',life: 3000,});
       console.log(this.ligneSaved)
     }); 

  }
  
  this.newbudget.id=this.idBudget;
  this.newbudget.montant_execute=0;
  this.newbudget.montant_propose_bureau=this.budgets;
  this.newbudget.montant_propose_drp=this.somme;
  this.newbudget.montant=0;
  this.budgetvalideService.modifier(this.newbudget,this.idstructure).subscribe( (data)=>{
    this.budgetsave=data
    console.log(this.budgetsave)
  });
  

 
  this.budgetvalideService.saveSuivi(this.newSuivi,this.idBudget,3).subscribe(data => {
    this.suiviSaved = data;
    console.log(this.suiviSaved)
  }); 
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
