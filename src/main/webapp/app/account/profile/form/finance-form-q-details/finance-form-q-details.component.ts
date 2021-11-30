import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Address, FormQ } from 'app/shared/models/forms.model';
import { isEmpty } from 'app/shared/util/utilities';
import { Subscription } from 'rxjs';
import { DataService } from '../services/data.service';
import { FormDataService } from '../services/form-data.service';

@Component({
  selector: 'jhi-finance-form-q-details',
  templateUrl: './finance-form-q-details.component.html',
  styleUrls: ['./finance-form-q-details.component.scss'],
})
export class FinanceFormQDetailsComponent implements OnInit, OnDestroy {
  @ViewChild('formQ', { static: false })
  public formQ!: NgForm;
  public form = new FormQ();
  public formQSubscription!: Subscription;
  public fatherOrSpouse: 'Father' | 'Spouse' = 'Father';
  public signatureUrl = '';
  public defaultUrl = 'https://www.motalleodds.no/wp-content/uploads/2018/01/347101-white-background-hd-2633x1542-for-full-hd.jpg';

  constructor(private router: Router, private formDataService: FormDataService, private dataService: DataService) {}

  ngOnInit(): void {
    this.formQSubscription = this.formDataService.onDataLoaded().subscribe(
      res => {
        if (res) {
          this.form = new FormQ(this.formDataService.getFormQDetails());
          this.onLoad();
        }
      },
      err => {
        console.error('Failed to load Data', err);
      }
    );
    this.onLoad();
  }

  onLoad(): void {
    const basicForm = this.formDataService.getBasicFormDetails();
    const personalForm = this.formDataService.getPesonalFormDetails();
    const pfForm = this.formDataService.getProvidentFundFormDetails();
    const financeIForm = this.formDataService.getFormIDetails();

    this.form.fullname = basicForm.firstname + ' ' + basicForm.lastname;
    this.form.dateOfAppointment = financeIForm.dateOfAppointment;

    this.form.postalAddress = !isEmpty(this.form.postalAddress)
      ? new Address(this.form.postalAddress)
      : !isEmpty(personalForm.permanentAddress)
      ? new Address(personalForm.permanentAddress)
      : new Address(basicForm.address);

    this.form.permanentAddress = !isEmpty(personalForm.permanentAddress)
      ? new Address(personalForm.permanentAddress)
      : new Address(basicForm.address);

    this.form.dateOfBirth = basicForm.dateOfBirth;
    this.form.fatherOrSpouseName = pfForm.fatherOrSpouseName;
  }

  onPrevious(): void {
    this.save();
    this.router.navigateByUrl('/account/form/form-i');
  }

  onSubmit(): void {
    this.save();
    this.dataService.post(this.formDataService.getCompleteForm()).subscribe(
      () => {
        alert('Sucessfully Updated');
        this.router.navigateByUrl('/');
      },
      err => {
        console.error(err);
      }
    );
  }

  save(): boolean {
    if (this.formQ.valid) {
      this.formDataService.setFormQDetails(this.form);
      return true;
    }
    return false;
  }

  ngOnDestroy(): void {
    this.formQSubscription.unsubscribe();
  }
}
