import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BureauvalideComponent } from './bureauvalide.component';

describe('BureauvalideComponent', () => {
  let component: BureauvalideComponent;
  let fixture: ComponentFixture<BureauvalideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BureauvalideComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BureauvalideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
