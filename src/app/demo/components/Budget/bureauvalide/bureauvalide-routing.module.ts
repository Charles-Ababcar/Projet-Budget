import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BureauvalideComponent } from './bureauvalide.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path:'', component: BureauvalideComponent }
	])],
	exports: [RouterModule]
})
export class BureauvaliderRoutingModule { }
