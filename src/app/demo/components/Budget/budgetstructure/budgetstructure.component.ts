import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { AuthServiceService } from 'src/app/layout/service/auth-service.service';
import { MonbudgetService } from 'src/app/layout/service/monbudget.service';

@Component({
  selector: 'app-budgetstructure',
  templateUrl: './budgetstructure.component.html',
  styleUrls: ['./budgetstructure.component.scss'],
  providers: [MessageService]
})
export class BudgetstructureComponent implements OnInit {

  constructor(private MonbudgetService : MonbudgetService,private serviceAuth:AuthServiceService,private messageService:MessageService) { }

  // eslint-disable-next-line @angular-eslint/no-empty-lifecycle-method
  ngOnInit(): void {
  }

}
