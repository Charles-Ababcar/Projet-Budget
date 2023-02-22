import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesRoutingModule } from './pages-routing.module';
//import { DemandeBudgetDRPComponent } from './demande-budget-drp/demande-budget-drp.component';
import { CrudComponent } from './crud/crud.component';

@NgModule({
    imports: [
        CommonModule,
        PagesRoutingModule
    ]
})
export class PagesModule { }
