import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BudgetstructureComponent } from './budgetstructure.component';

describe('BudgetstructureComponent', () => {
  let component: BudgetstructureComponent;
  let fixture: ComponentFixture<BudgetstructureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BudgetstructureComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BudgetstructureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
