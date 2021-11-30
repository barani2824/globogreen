import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { OrdersService } from '../admin/orders/orders.service';
import { Orders } from '../admin/orders/orders.component';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  orders: Orders[] | null = null;
  account: Account | null = null;
  authSubscription?: Subscription;
  orderSubscription?: Subscription;
  constructor(private accountService: AccountService, private loginModalService: LoginModalService
    , private ordersService:OrdersService) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(orders => (this.account = orders));
    this.orderSubscription = this.ordersService.get().subscribe(orders => (this.orders = orders));
  
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
    if (this.orderSubscription) {
      this.orderSubscription.unsubscribe();
    }
  }
}
