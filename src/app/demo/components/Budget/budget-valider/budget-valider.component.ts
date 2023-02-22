import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { AuthServiceService } from 'src/app/layout/service/auth-service.service';
import { BudgetValiderService } from 'src/app/layout/service/budget-valider.service';

@Component({
  selector: 'app-budget-valider',
  templateUrl: './budget-valider.component.html',
  styleUrls: ['./budget-valider.component.scss'],
  providers: [MessageService]
})
export class BudgetValiderComponent implements OnInit {
  infosUser:any;
  idroleuser: number=0;
  idstuser: number=0;

  constructor( private serviceAuth:AuthServiceService, private budgetvalideService:BudgetValiderService, private messageService:MessageService) { }

  // eslint-disable-next-line @angular-eslint/no-empty-lifecycle-method
  ngOnInit(): void {
    this.getInfosUsername();
  }
  getInfosUsername(){
    this.serviceAuth.infosUsername().subscribe(
        (data) => {
            this.infosUser = data;
            console.log(this.infosUser);
            for (let c of this.infosUser) {
              this.idroleuser=c.idrole;
              this.idstuser=c.id;
              console.log(this.idroleuser,this.idstuser);
            }
        })
    }



}
