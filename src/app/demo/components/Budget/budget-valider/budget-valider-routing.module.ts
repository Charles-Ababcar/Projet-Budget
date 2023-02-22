import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BudgetValiderComponent } from './budget-valider.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path:'', component: BudgetValiderComponent }
	])],
	exports: [RouterModule]
})
export class BudgetValiderRoutingModule { }
