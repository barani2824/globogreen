import { TestBed, async, inject } from '@angular/core/testing';

import { FinanceFormQGuard } from './finance-form-q.guard';

describe('FinanceFormQGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinanceFormQGuard],
    });
  });

  it('should ...', inject([FinanceFormQGuard], (guard: FinanceFormQGuard) => {
    expect(guard).toBeTruthy();
  }));
});
