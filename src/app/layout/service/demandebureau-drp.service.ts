import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Drp } from '../../demo/model/drp';

@Injectable({
  providedIn: 'root'
})
export class DemandebureauDrpService {

  constructor(private http:HttpClient) { }

public listDrp():Observable<any[]>{
  return this.http.get<Drp[]>(environment.apiUrl+"/apiSuiviBudget/BudgetEnAttenteDRP");
}

public consulterDrp(id:number){
  return this.http.get(environment.apiUrl+"/apiSuiviBudget/BudgetDrpEnAttente/"+id)
}

public  consulter(id:number){
  return this.http.get(environment.apiUrl+"/apiSuiviBudget/BudgetEnAttente/"+id)
}
public consulterBureau(id:number, idEtat:number){
  return this.http.get(environment.apiUrl+"/apiSuiviBudget/BudgetBureauxEnAttente/"+id+"/"+idEtat)
}

}
