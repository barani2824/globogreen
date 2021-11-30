import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceFormFDetailsComponent } from './finance-form-f-details.component';

describe('FinanceFormFDetailsComponent', () => {
  let component: FinanceFormFDetailsComponent;
  let fixture: ComponentFixture<FinanceFormFDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FinanceFormFDetailsComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceFormFDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
