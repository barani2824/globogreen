import { TestBed, async, inject } from '@angular/core/testing';

import { BasicFormGuard } from './basic-form.guard';

describe('BasicFormGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BasicFormGuard],
    });
  });

  it('should ...', inject([BasicFormGuard], (guard: BasicFormGuard) => {
    expect(guard).toBeTruthy();
  }));
});
