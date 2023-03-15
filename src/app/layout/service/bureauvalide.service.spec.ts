import { TestBed } from '@angular/core/testing';

import { BureauvalideService } from './bureauvalide.service';

describe('BureauvalideService', () => {
  let service: BureauvalideService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BureauvalideService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
