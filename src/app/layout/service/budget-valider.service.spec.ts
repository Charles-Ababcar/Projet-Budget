import { TestBed } from '@angular/core/testing';

import { BudgetValiderService } from './budget-valider.service';

describe('BudgetValiderService', () => {
  let service: BudgetValiderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BudgetValiderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
