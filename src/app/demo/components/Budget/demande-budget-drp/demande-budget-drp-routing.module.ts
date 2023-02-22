import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DemandeBudgetDrpComponent } from './demande-budget-drp.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path:'', component:  DemandeBudgetDrpComponent}
	])],
	exports: [RouterModule]
})
export class DemandeBudgetDrpRoutingModule { }
