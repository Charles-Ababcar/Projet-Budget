import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DemandeBudgetComponent } from './demande-budget.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path:'', component: DemandeBudgetComponent }
	])],
	exports: [RouterModule]
})
export class DemandeBudgetRoutingModule { }
