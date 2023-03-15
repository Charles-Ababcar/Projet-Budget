import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MonbudgetService {

  constructor(private http: HttpClient) { }

  public infosBudget(idstructure: number,idetat: number){
    return this.http.get(environment.apiUrl+"/apiSuiviBudget/BudgetEnAttente/"+idstructure+"/"+idetat);
  }

  public infosBudgetDrp(iddrp: number,annee: number,idetat: number){
    return this.http.get(environment.apiUrl+"/apiBudget/budgetDRP/"+iddrp+"/"+annee+"/"+idetat);
  }
  public infosAllCompteBudget(idBudget: number,idetat: number){
    return this.http.get(environment.apiUrl+"/apiLigneBudget/budgetParCompte/"+idBudget+"/"+idetat);
  }


  public infosCompteBudget(idBudget: number,num: number,idetat: number){
    return this.http.get(environment.apiUrl+"/apiLigneBudget/budgetUnCompte/"+idBudget+"/"+num+"/"+idetat);
  }
  
  public infosDecaissementCompteBudget(num: number,idBudget: number,idetat: number){
    return this.http.get(environment.apiUrl+"/apiDecaissement/depensesByCompte/"+num+"/"+idBudget+"/"+idetat);
  }

}
