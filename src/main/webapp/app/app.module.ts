import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { OnboardingHelperSharedModule } from 'app/shared/shared.module';
import { OnboardingHelperCoreModule } from 'app/core/core.module';
import { OnboardingHelperAppRoutingModule } from './app-routing.module';
import { OnboardingHelperHomeModule } from './home/home.module';
import { OnboardingHelperEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { OrdersModule } from './admin/orders/orders.module';

@NgModule({
  imports: [
    BrowserModule,
    OnboardingHelperSharedModule,
    OnboardingHelperCoreModule,
    OnboardingHelperHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    OnboardingHelperEntityModule,
    OnboardingHelperAppRoutingModule,
    OrdersModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class OnboardingHelperAppModule {}
