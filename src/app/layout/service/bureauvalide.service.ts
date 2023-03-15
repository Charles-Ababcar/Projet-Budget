import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Budget } from 'src/app/demo/model/budget';
import { LigneBudgetaire } from 'src/app/demo/model/ligneBudgetaire';
import { SuiviBudget } from 'src/app/demo/model/suiviBudget';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BureauvalideService {

  constructor(private http: HttpClient) { }

  public consulterCompte(idBudget: number,idEtat:number){
    return this.http.get(environment.apiUrl+"/apiLigneBudget/budgetParCompte/"+idBudget+"/"+idEtat);
  }
  public monbur(idstructure: number,idetat: number){
    return this.http.get(environment.apiUrl+ "/apiSuiviBudget/BudgetEnAttente/"+idstructure+"/"+idetat);
  }
  public modifier(budget: Budget,idstructure:number) {
    return this.http.put(environment.apiUrl+"/apiBudget/modifierBudget/"+idstructure, budget);
  }
  
  public saveLigne(lignebudget: LigneBudgetaire,idbudget:number,idcompte:number) {
    return this.http.put(environment.apiUrl+"/apiLigneBudget/modifierLigneBudget/"+idbudget+"/"+idcompte,lignebudget);
  }
  public  updateLigne(listLigne?:LigneBudgetaire){
    return this.http.put(environment.apiUrl+"/apiLigneBudget/modifierLigneBudget",listLigne);
  }

  public saveSuivi(suiviBudget:SuiviBudget,idbudget:number,idEtat:number) {
    return this.http.put(environment.apiUrl+"/apiSuiviBudget/modifierSuiviBudget/"+idbudget+"/"+idEtat, suiviBudget);
  
  }

}
