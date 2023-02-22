import { TestBed } from '@angular/core/testing';

import { DemandeBudgetService } from './demande-budget.service';

describe('DemandeBudgetService', () => {
  let service: DemandeBudgetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemandeBudgetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
