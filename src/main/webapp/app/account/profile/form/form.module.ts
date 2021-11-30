import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DragAndDropDirective } from 'app/shared/directives/drag-and-drop.directive';
import { NumberToArrayPipe } from 'app/shared/pipes/number-to-array.pipe';
import { SafeResourceUrlPipe } from 'app/shared/pipes/safe-resource-url.pipe';
import { BasicDetailsFormComponent } from './basic-details/basic-details.component';
import { FinanceFormFDetailsComponent } from './finance-form-f-details/finance-form-f-details.component';
import { FinanceFormIDetailsComponent } from './finance-form-i-details/finance-form-i-details.component';
import { FinanceFormQDetailsComponent } from './finance-form-q-details/finance-form-q-details.component';
import { FormRoutingModule } from './form-routing.module';
import { FormComponent } from './form.component';
import { PersonalDetailsFormComponent } from './personal-details/personal-details.component';
import { ProvidentFundDetailsFormComponent } from './pf-details/pf-details.component';

@NgModule({
  declarations: [
    FormComponent,
    BasicDetailsFormComponent,
    PersonalDetailsFormComponent,
    ProvidentFundDetailsFormComponent,
    FinanceFormFDetailsComponent,
    FinanceFormIDetailsComponent,
    FinanceFormQDetailsComponent,
    DragAndDropDirective,
    NumberToArrayPipe,
    SafeResourceUrlPipe,
  ],
  imports: [CommonModule, FormRoutingModule, FormsModule, HttpClientModule],
})
export class FormModule {}
