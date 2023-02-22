import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BudgetValiderComponent } from './budget-valider.component';

describe('BudgetValiderComponent', () => {
  let component: BudgetValiderComponent;
  let fixture: ComponentFixture<BudgetValiderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BudgetValiderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BudgetValiderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
