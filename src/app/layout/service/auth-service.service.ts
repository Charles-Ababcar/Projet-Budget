import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../../demo/model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  
  constructor(private http: HttpClient, private keycloak:KeycloakService) { }

  public infosUsername(){
    return this.http.get(environment.apiUrl+"/apiUser/user/"+"camara");
  }
}
