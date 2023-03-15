import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BudgetstructureComponent } from './budgetstructure.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path:'', component: BudgetstructureComponent }
	])],
	exports: [RouterModule]
})
export class BudgetStructureRoutingModule { }
