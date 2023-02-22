import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { PrimeNGConfig } from 'primeng/api';
import { environment } from 'src/environments/environment';
import { UserconnectService } from './layout/service/userconnect.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent {
    menuMode = 'static';
    email:any

    user:any

    constructor(private primengConfig: PrimeNGConfig,private userconnecte: UserconnectService, private keycloak: KeycloakService, private http: HttpClient ) { }

    // eslint-disable-next-line @angular-eslint/use-lifecycle-interface
    ngOnInit() {
        this.primengConfig.ripple = true;

    
//console.log(this.keycloak.getKeycloakInstance().realmAccess.roles)


//this.email= this.keycloak.getKeycloakInstance().profile.username
/*    if(this.keycloak.getKeycloakInstance().authenticated)
{
   */

    // this.http.get(environment.apiUrl+"/dg_User/email/"+this.email).subscribe
    // (
    //     (data)=>
    //     {
    //         this.user=data

    //         localStorage.setItem('user', JSON.stringify(this.user))


    //     }
    // )







//this.userconnecte.getDrp().then(data => console.log(data))
//this.userconnecte.getUser().then((data) =>
//{


// this.user=data
// console.log(this.user)
// }
// )
}
}
