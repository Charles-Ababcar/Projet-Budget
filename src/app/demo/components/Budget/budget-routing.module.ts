import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [RouterModule.forChild([
		 { path: 'demande-budget', loadChildren: () => import('./demande-budget/demandeBudget.module').then(m => m.DemandeBudgetModule) },
		 { path: 'demande-budget-drp', loadChildren: () => import('./demande-budget-drp/demandeDrp.module').then(m => m.DemandeBudgetDrpModule) },
         { path: 'budget-valider', loadChildren: () => import('./budget-valider/budget-valider.module').then(m => m.BudgetValiderModule) },


		 // { path: 'crud', loadChildren: () => import('./crud/crud.module').then(m => m.CrudModule) },
        // { path: 'demande-budget-drp', loadChildren: () => import('./demande-budget-drp/DemandeBudgetDrp.module').then(m => m.DemandeBudgetDrpModule) },
        // { path: 'empty', loadChildren: () => import('./empty/emptydemo.module').then(m => m.EmptyDemoModule) },
        // { path: 'timeline', loadChildren: () => import('./timeline/timelinedemo.module').then(m => m.TimelineDemoModule) },
        { path: '**', redirectTo: '/notfound' }
    ])],
    exports: [RouterModule]
})
export class BudgetsRoutingModule { }
