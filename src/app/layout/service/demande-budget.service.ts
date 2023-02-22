import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Budget } from '../../demo/model/budget';
import { CompteBudget } from '../../demo/model/compteBudget';
import { LigneBudgetaire } from '../../demo/model/ligneBudgetaire';
import { SuiviBudget } from '../../demo/model/suiviBudget';

@Injectable({
  providedIn: 'root'
})
export class DemandeBudgetService {
  constructor(private http:HttpClient) { }
  httpOptions =
  {
      headers: new HttpHeaders({
          'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/JSON',
        'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
      })
  };

  public find(number:number, number1:number):Observable<CompteBudget[]>{
    return this.http.get<CompteBudget[]>(environment.apiUrl+"/apiCompteBudget/listeCompteparStructure/"+number+"/"+number1)
  }

public sum(number :number, somme:number){
  return this.http.get(environment.apiUrl+"/apiBudget/sommebudget/"+number+"/"+somme)
}

public save(budget:Budget)
{
  return this.http.post(environment.apiUrl+"/apiBudget/addBudget",budget)
}

public saveLigne(idbudget?:number,listCompte?:CompteBudget[])
{
  return this.http.post(environment.apiUrl+"/apiLigneBudget/addLigneBudget/"+idbudget,listCompte)
}

public saveSuivi(suivibudget:SuiviBudget,idbudget:number, idetat:number)
{
  return this.http.post<SuiviBudget>(environment.apiUrl+"/apiSuiviBudget/addSuiviBudget/"+idbudget+"/"+idetat,suivibudget)
}

}
