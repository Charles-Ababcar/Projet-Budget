import { TestBed } from '@angular/core/testing';

import { DemandebureauDrpService } from './demandebureau-drp.service';

describe('DemandebureauDrpService', () => {
  let service: DemandebureauDrpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemandebureauDrpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
