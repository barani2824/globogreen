import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceFormIDetailsComponent } from './finance-form-i-details.component';

describe('FinanceFormIDetailsComponent', () => {
  let component: FinanceFormIDetailsComponent;
  let fixture: ComponentFixture<FinanceFormIDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FinanceFormIDetailsComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceFormIDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
