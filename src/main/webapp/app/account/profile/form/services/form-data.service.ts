import { Injectable, OnDestroy } from '@angular/core';
import { BasicForm, CompleteForm, FormF, FormI, FormQ, FormValidity, PersonalForm, ProvidentFundForm } from 'app/shared/models/forms.model';
import { BehaviorSubject, Observable, Subscription } from 'rxjs';
import { DataService } from './data.service';
import { AccountService } from 'app/core/auth/account.service';
import { switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class FormDataService implements OnDestroy {
  private completeForm: CompleteForm;
  private form: FormValidity = {
    basicForm: false,
    personalForm: false,
    pFForm: false,
    formF: false,
    formI: false,
    formQ: false,
  };
  private email: string | undefined;
  private firstname: string | undefined;
  private lastname: string | undefined;
  private dataLoaded = new BehaviorSubject<boolean>(false);
  private accountSubscription: Subscription = new Subscription();
  private loginSubscription: Subscription;

  constructor(private dataService: DataService, private accountSevice: AccountService) {
    this.completeForm = new CompleteForm();
    this.loginSubscription = this.accountSevice.getAccountObservable().subscribe(() => {
      this.onLoad();
    });
    this.onLoad();
  }
  onLoad(): void {
    if (this.accountSubscription) this.accountSubscription.unsubscribe();
    this.accountSubscription = this.accountSevice
      .getAccount()
      .pipe(
        switchMap(account => {
          this.email = account?.email;
          this.firstname = account?.firstName;
          this.lastname = account?.lastName;
          return this.dataService.get(account?.email);
        })
      )
      .subscribe(
        res => {
          this.completeForm = new CompleteForm(res);
          this.setAllFormValid(true);
          this.dataLoaded.next(true);
        },
        err => {
          console.error(err);
          this.completeForm = new CompleteForm();
          this.setAllFormValid(false);
          this.dataLoaded.next(true);
        }
      );
  }

  public getEmail(): string | undefined {
    return this.email;
  }

  public getFirstname(): string | undefined {
    return this.firstname;
  }

  public getLastName(): string | undefined {
    return this.lastname;
  }

  public onDataLoaded(): Observable<boolean> {
    return this.dataLoaded as Observable<boolean>;
  }

  getBasicFormDetails(): BasicForm {
    return this.completeForm.basicForm;
  }

  getPesonalFormDetails(): PersonalForm {
    return this.completeForm.personalForm;
  }

  getProvidentFundFormDetails(): ProvidentFundForm {
    return this.completeForm.providentFundForm;
  }

  getFormFDetails(): FormF {
    return this.completeForm.formF;
  }

  getFormIDetails(): FormI {
    return this.completeForm.formI;
  }

  getFormQDetails(): FormQ {
    return this.completeForm.formQ;
  }

  setBasicFormDetails(basicForm: BasicForm): void {
    this.setBasicFormValid(true);
    this.completeForm.basicForm = new BasicForm(basicForm);
  }

  setPesonalFormDetails(personalForm: PersonalForm): void {
    this.setPersonalFormValid(true);
    this.completeForm.personalForm = new PersonalForm(personalForm);
  }

  setProvidentFundFormDetails(providentFundForm: ProvidentFundForm): void {
    this.setProvidentFundFormValid(true);
    this.completeForm.providentFundForm = new ProvidentFundForm(providentFundForm);
  }

  setFormFDetails(formF: FormF): void {
    this.setFormFValid(true);
    this.completeForm.formF = new FormF(formF);
  }

  setFormIDetails(formI: FormI): void {
    this.setFormIValid(true);
    this.completeForm.formI = new FormI(formI);
  }

  setFormQDetails(formQ: FormQ): void {
    this.setFormQValid(true);
    this.completeForm.formQ = new FormQ(formQ);
  }

  getCompleteForm(): CompleteForm {
    return this.completeForm;
  }

  isBasicFormValid(): boolean {
    return this.form.basicForm;
  }

  isPersonalFormValid(): boolean {
    return this.form.personalForm;
  }

  isProvidentFundFormValid(): boolean {
    return this.form.pFForm;
  }

  isFormFValid(): boolean {
    return this.form.formF;
  }

  isFormIValid(): boolean {
    return this.form.formI;
  }

  isFormQValid(): boolean {
    return this.form.formQ;
  }

  setBasicFormValid(value: boolean): void {
    this.form.basicForm = value;
  }

  setPersonalFormValid(value: boolean): void {
    this.form.personalForm = value;
  }

  setProvidentFundFormValid(value: boolean): void {
    this.form.pFForm = value;
  }

  setFormFValid(value: boolean): void {
    this.form.formF = value;
  }

  setFormIValid(value: boolean): void {
    this.form.formI = value;
  }

  setFormQValid(value: boolean): void {
    this.form.formQ = value;
  }

  isAllFormValid(): boolean {
    return (
      this.isBasicFormValid() &&
      this.isPersonalFormValid() &&
      this.isProvidentFundFormValid() &&
      this.isFormFValid() &&
      this.isFormIValid() &&
      this.isFormQValid()
    );
  }

  setAllFormValid(value: boolean): void {
    this.setBasicFormValid(value);
    this.setPersonalFormValid(value);
    this.setProvidentFundFormValid(value);
    this.setFormFValid(value);
    this.setFormIValid(value);
    this.setFormQValid(value);
  }

  ngOnDestroy(): void {
    this.accountSubscription.unsubscribe();
    this.loginSubscription.unsubscribe();
  }
}
