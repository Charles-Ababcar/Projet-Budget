import { TestBed } from '@angular/core/testing';

import { MonbudgetService } from './monbudget.service';

describe('MonbudgetService', () => {
  let service: MonbudgetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MonbudgetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
