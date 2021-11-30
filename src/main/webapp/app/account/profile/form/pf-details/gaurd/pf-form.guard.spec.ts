import { TestBed, async, inject } from '@angular/core/testing';

import { PfFormGuard } from './pf-form.guard';

describe('PfFormGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PfFormGuard],
    });
  });

  it('should ...', inject([PfFormGuard], (guard: PfFormGuard) => {
    expect(guard).toBeTruthy();
  }));
});
