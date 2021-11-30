import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrandManagementComponent } from './brand-management.component';

import { OnboardingHelperSharedModule } from 'app/shared/shared.module';


import { BrandManagementRoute } from './brand-management.route';

@NgModule({
  imports: [OnboardingHelperSharedModule, RouterModule.forChild([BrandManagementRoute])],
  declarations: [BrandManagementComponent],
})
export class BrandManagementModule {}
