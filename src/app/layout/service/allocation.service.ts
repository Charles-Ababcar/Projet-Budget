import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Allocation } from '../../demo/model/allocation';

@Injectable({
  providedIn: 'root'
})
export class AllocationService {

  constructor(private http:HttpClient) { }


  public getinfoallocation(idLigne:number):Observable<any[]>{
    return this.http.get<Allocation[]>(environment.apiUrl+"apiAllocation/getAllocationByLigne/"+idLigne)
  }
}
