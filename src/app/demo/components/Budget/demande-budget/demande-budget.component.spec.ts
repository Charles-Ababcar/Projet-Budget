import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeBudgetComponent } from './demande-budget.component';

describe('DemandeBudgetComponent', () => {
  let component: DemandeBudgetComponent;
  let fixture: ComponentFixture<DemandeBudgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandeBudgetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemandeBudgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
