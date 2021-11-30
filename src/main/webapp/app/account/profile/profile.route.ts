import { Route } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Authority } from 'app/shared/constants/authority.constants';

export const profileRoute: Route = {
  path: 'form',
  loadChildren: async () => (await import('./form/form.module')).FormModule,
  data: {
    authorities: [Authority.USER],
    pageTitle: 'Form',
  },
  canActivate: [UserRouteAccessService],
};
