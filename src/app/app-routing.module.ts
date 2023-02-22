import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { NotfoundComponent } from './demo/components/notfound/notfound.component';
import { AppLayoutComponent } from "./layout/app.layout.component";
//import { DemandeBudgetComponent } from './Budget/demande-budget/demande-budget.component';
import { AuthGuard } from './layout/service/auth.guard';
//import { DemandeBudgetDrpComponent } from './Budget/demande-budget-drp/demande-budget-drp.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            {
                path: '', component: AppLayoutComponent,
                canActivate:[AuthGuard],
                children: [
                    { path: '', loadChildren: () => import('./demo/components/dashboard/dashboard.module').then(m => m.DashboardModule) },
                    { path: 'uikit', loadChildren: () => import('./demo/components/uikit/uikit.module').then(m => m.UIkitModule) },
                    { path: 'utilities', loadChildren: () => import('./demo/components/utilities/utilities.module').then(m => m.UtilitiesModule) },
                    { path: 'documentation', loadChildren: () => import('./demo/components/documentation/documentation.module').then(m => m.DocumentationModule) },
                    { path: 'blocks', loadChildren: () => import('./demo/components/primeblocks/primeblocks.module').then(m => m.PrimeBlocksModule) },
                    { path: 'pages', loadChildren: () => import('./demo/components/pages/pages.module').then(m => m.PagesModule) },
                    {path: 'Budget', loadChildren: () => import('./demo/components/Budget/budget.module').then(m => m.BudgetsModule) },


                    //Routing
                    
                    //{path: 'budget/demandeBudget', component: DemandeBudgetComponent},

                   {path: 'demandeBudgetDrp', loadChildren: () => import('./demo/components/pages/pages.module').then(m => m.PagesModule) },
                   {path: 'demandeBudget', loadChildren: () => import('./demo/components/Budget/budget.module').then(m => m.BudgetsModule) },
                   {path: 'budgetValider', loadChildren: () => import('./demo/components/Budget/budget.module').then(m => m.BudgetsModule) },

                   // {path: 'organisations/annexes', component: AnnexesComponent},
                    // {path: 'organisations/bureaux/affecterAnnexe', component: AffecterAnnexeComponent},
                    // {path: 'organisations/centres', component: CentresComponent},
                    // {path: 'organisations/directions', component: DirectionsComponent},
                    // {path: 'organisations/bureaux', component: BureauComponent},


                ]
            },
            { path: 'auth', loadChildren: () => import('./demo/components/auth/auth.module').then(m => m.AuthModule) },
            { path: 'landing', loadChildren: () => import('./demo/components/landing/landing.module').then(m => m.LandingModule) },
            { path: 'notfound', component: NotfoundComponent },
            { path: '**', redirectTo: '/notfound' },
        ], { scrollPositionRestoration: 'enabled', anchorScrolling: 'enabled', onSameUrlNavigation: 'reload' })
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
