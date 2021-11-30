import { TestBed, async, inject } from '@angular/core/testing';

import { FinanceFormFGuard } from './finance-form-f.guard';

describe('FinanceFormFGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinanceFormFGuard],
    });
  });

  it('should ...', inject([FinanceFormFGuard], (guard: FinanceFormFGuard) => {
    expect(guard).toBeTruthy();
  }));
});
