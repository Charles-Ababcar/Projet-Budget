import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  
  constructor(private http: HttpClient, private keycloak:KeycloakService) { }

  public infosUsername(){
    return this.http.get(environment.apiUrl+"/apiUser/user/"+"balde");
  }
}
