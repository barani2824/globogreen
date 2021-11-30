import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceFormQDetailsComponent } from './finance-form-q-details.component';

describe('FinanceFormQDetailsComponent', () => {
  let component: FinanceFormQDetailsComponent;
  let fixture: ComponentFixture<FinanceFormQDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FinanceFormQDetailsComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceFormQDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
