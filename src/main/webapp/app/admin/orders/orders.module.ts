import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { OrdersComponent } from './orders.component';

import { OnboardingHelperSharedModule } from 'app/shared/shared.module';


import { metricsRoute } from './orders.route';

@NgModule({
  imports: [OnboardingHelperSharedModule, RouterModule.forChild([metricsRoute])],
  declarations: [OrdersComponent],
})
export class OrdersModule {}
