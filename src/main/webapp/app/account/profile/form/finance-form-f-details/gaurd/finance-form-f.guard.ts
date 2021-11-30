/* eslint-disable @typescript-eslint/no-unused-vars */
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { FormDataService } from '../../services/form-data.service';

@Injectable({
  providedIn: 'root',
})
export class FinanceFormFGuard implements CanActivate {
  constructor(private router: Router, private formDataService: FormDataService) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.formDataService.isProvidentFundFormValid()) {
      return true;
    } else {
      this.router.navigateByUrl('/form/basic-form');
      return false;
    }
  }
}
