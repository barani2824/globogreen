import { TestBed, async, inject } from '@angular/core/testing';

import { FinanceFormIGuard } from './finance-form-i.guard';

describe('FinanceFormIGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinanceFormIGuard],
    });
  });

  it('should ...', inject([FinanceFormIGuard], (guard: FinanceFormIGuard) => {
    expect(guard).toBeTruthy();
  }));
});
