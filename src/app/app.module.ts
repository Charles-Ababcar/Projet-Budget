import { APP_INITIALIZER, NgModule } from '@angular/core';
import {  HashLocationStrategy, LocationStrategy } from '@angular/common';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AppLayoutModule } from './layout/app.layout.module';
import { NotfoundComponent } from './demo/components/notfound/notfound.component';
import { ProductService } from './demo/service/product.service';
import { CountryService } from './demo/service/country.service';
import { CustomerService } from './demo/service/customer.service';
import { EventService } from './demo/service/event.service';
import { IconService } from './demo/service/icon.service';
import { NodeService } from './demo/service/node.service';
import { PhotoService } from './demo/service/photo.service';
//import { DemandeBudgetDrpComponent } from './Budget/demande-budget-drp/demande-budget-drp.component';
import { initializeKeycloak } from './layout/service/app.init';
//import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { DemandebureauDrpService } from './layout/service/demandebureau-drp.service';
import { DemandeBudgetService } from './layout/service/demande-budget.service';


@NgModule({
    declarations: [
        AppComponent, 
        NotfoundComponent, 
        
       // DemandeBudgetDrpComponent,
        //DemandeBudgetDrpComponent
    ],
    imports: [
        AppRoutingModule,
        AppLayoutModule,
        KeycloakAngularModule
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy },
       //{provide:HTTP_INTERCEPTORS,useClass:InterceptorService,multi:true},
        {
            provide: APP_INITIALIZER,
            useFactory: initializeKeycloak,
            multi: true,
            deps: [KeycloakService]
          },

        CountryService, CustomerService, EventService, IconService, NodeService,
        PhotoService, ProductService,DemandebureauDrpService,DemandeBudgetService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
