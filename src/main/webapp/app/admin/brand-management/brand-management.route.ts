import { Route } from '@angular/router';

import { BrandManagementComponent } from './brand-management.component';

export const BrandManagementRoute: Route = {
  path: '',
  component: BrandManagementComponent,
  data: {
    pageTitle: 'Brand Management',
  },
};
