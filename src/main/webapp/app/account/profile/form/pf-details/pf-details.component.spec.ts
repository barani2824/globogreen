import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProvidentFundDetailsFormComponent } from './pf-details.component';

describe('ProvidentFundDetailsFormComponent', () => {
  let component: ProvidentFundDetailsFormComponent;
  let fixture: ComponentFixture<ProvidentFundDetailsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ProvidentFundDetailsFormComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProvidentFundDetailsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
