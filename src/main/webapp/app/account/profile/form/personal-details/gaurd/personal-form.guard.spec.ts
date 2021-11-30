import { TestBed, async, inject } from '@angular/core/testing';

import { PersonalFormGuard } from './personal-form.guard';

describe('PersonalFormGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PersonalFormGuard],
    });
  });

  it('should ...', inject([PersonalFormGuard], (guard: PersonalFormGuard) => {
    expect(guard).toBeTruthy();
  }));
});
