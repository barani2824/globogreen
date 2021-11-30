import { NgModule } from '@angular/core';
import { OnboardingHelperSharedLibsModule } from './shared-libs.module';
import { AlertComponent } from './alert/alert.component';
import { AlertErrorComponent } from './alert/alert-error.component';
import { LoginModalComponent } from './login/login.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import {FileUploadModule} from 'primeng/fileupload';
@NgModule({
  imports: [OnboardingHelperSharedLibsModule],
  declarations: [AlertComponent, AlertErrorComponent, LoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [LoginModalComponent],
  exports: [OnboardingHelperSharedLibsModule, AlertComponent, AlertErrorComponent, LoginModalComponent, HasAnyAuthorityDirective,FileUploadModule],
})
export class OnboardingHelperSharedModule {}
