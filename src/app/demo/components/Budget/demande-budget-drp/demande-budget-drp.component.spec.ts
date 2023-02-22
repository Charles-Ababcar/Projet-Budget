import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeBudgetDrpComponent } from './demande-budget-drp.component';

describe('DemandeBudgetDrpComponent', () => {
  let component: DemandeBudgetDrpComponent;
  let fixture: ComponentFixture<DemandeBudgetDrpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandeBudgetDrpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemandeBudgetDrpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
