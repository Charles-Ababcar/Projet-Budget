import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
// import { firstValueFrom } from 'rxjs';
// import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserconnectService {
  email: string | undefined;

  constructor(private http: HttpClient, private keycloak: KeycloakService) { 
    
    if (this.keycloak.getKeycloakInstance().authenticated){

      console.log(this.keycloak.getKeycloakInstance())
      this.email=this.keycloak.getKeycloakInstance().profile?.username
    
    console.log(this.email)
 }
  }

  //  getUser() {
  //   return  (this.http.get(environment.apiUrl+"/dg_User/email/"+this.email))
  // }

  


 

  // async getDrp ()
  // {    
  // return   await firstValueFrom(  this.http.get(environment.apiUrl+"/dg_Drp/1"))
  // }
}
