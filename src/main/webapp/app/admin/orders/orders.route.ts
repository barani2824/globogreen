import { Route } from '@angular/router';

import { OrdersComponent } from './orders.component';

export const metricsRoute: Route = {
  path: '',
  component: OrdersComponent,
  data: {
    pageTitle: 'Application Metrics',
  },
};
