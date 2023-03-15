import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Budget } from 'src/app/demo/model/budget';
import { LigneBudgetaire } from 'src/app/demo/model/ligneBudgetaire';
import { SuiviBudget } from 'src/app/demo/model/suiviBudget';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BudgetValiderService {

  constructor(private http:HttpClient) { }



  public  ListeBureau(iddrp:number,idEtat:number){
    return this.http.get(environment.apiUrl+"/apiSuiviBudget/BudgetBureauxEnAttente/"+iddrp+"/"+idEtat)
  }


  public  budgetParCompte(){
    return this.http.get(environment.apiUrl+"/apiLigneBudget/budgetParCompte")
  }

  public  consulterCompte(idbudget: number,idEtat:number){
    return this.http.get(environment.apiUrl+"/apiLigneBudget/budgetParCompte/"+idbudget+"/"+idEtat)
  }

  public  modifier(budget: Budget,idstructure:number){
    return this.http.put(environment.apiUrl+"/apiBudget/modifierBudget/"+idstructure,budget)
  }
  public  updateLigne(listLigne?:LigneBudgetaire){
    return this.http.put(environment.apiUrl+"/apiLigneBudget/modifierLigneBudget",listLigne);
  }

  public  saveSuivi(suiviBudget:SuiviBudget,idbudget:number,idEtat:number)
  {
    return this.http.put<SuiviBudget>(environment.apiUrl+"/apiSuiviBudget/modifierSuiviBudget/"+idbudget+"/"+idEtat, suiviBudget);
  }

  
}
