import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasicDetailsFormComponent } from './basic-details/basic-details.component';
import { FinanceFormFDetailsComponent } from './finance-form-f-details/finance-form-f-details.component';
import { FinanceFormFGuard } from './finance-form-f-details/gaurd/finance-form-f.guard';
import { FinanceFormIDetailsComponent } from './finance-form-i-details/finance-form-i-details.component';
import { FinanceFormIGuard } from './finance-form-i-details/gaurd/finance-form-i.guard';
import { FinanceFormQDetailsComponent } from './finance-form-q-details/finance-form-q-details.component';
import { FinanceFormQGuard } from './finance-form-q-details/gaurd/finance-form-q.guard';
import { FormComponent } from './form.component';
import { PersonalFormGuard } from './personal-details/gaurd/personal-form.guard';
import { PersonalDetailsFormComponent } from './personal-details/personal-details.component';
import { PfFormGuard } from './pf-details/gaurd/pf-form.guard';
import { ProvidentFundDetailsFormComponent } from './pf-details/pf-details.component';

const routes: Routes = [
  {
    path: '',
    component: FormComponent,
    children: [
      { path: '', redirectTo: 'basic-form', pathMatch: 'full' },
      { path: 'basic-form', component: BasicDetailsFormComponent },
      { path: 'personal-form', component: PersonalDetailsFormComponent, canActivate: [PersonalFormGuard] },
      { path: 'pf-form', component: ProvidentFundDetailsFormComponent, canActivate: [PfFormGuard] },
      { path: 'form-f', component: FinanceFormFDetailsComponent, canActivate: [FinanceFormFGuard] },
      { path: 'form-i', component: FinanceFormIDetailsComponent, canActivate: [FinanceFormIGuard] },
      { path: 'form-q', component: FinanceFormQDetailsComponent, canActivate: [FinanceFormQGuard] },
      { path: '**', redirectTo: 'basic-form', pathMatch: 'full' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FormRoutingModule {}
