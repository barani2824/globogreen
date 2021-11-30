import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MaritialStatus } from 'app/shared/models/enums.models';
import { Address, FormI, Nominee } from 'app/shared/models/forms.model';
import { isEmpty } from 'app/shared/util/utilities';
import { Subscription } from 'rxjs';
import { FormDataService } from '../services/form-data.service';

@Component({
  selector: 'jhi-finance-form-i-details',
  templateUrl: './finance-form-i-details.component.html',
  styleUrls: ['./finance-form-i-details.component.scss'],
})
export class FinanceFormIDetailsComponent implements OnInit, OnDestroy {
  @ViewChild('formI', { static: false })
  public formI!: NgForm;
  public maritalStatuses = MaritialStatus;
  public form: FormI = new FormI();
  public formISubscription!: Subscription;
  public noOfNominees = 0;
  constructor(private router: Router, private formDataService: FormDataService) {}

  ngOnInit(): void {
    this.formISubscription = this.formDataService.onDataLoaded().subscribe(
      res => {
        if (res) {
          this.form = new FormI(this.formDataService.getFormIDetails());
          this.noOfNominees = this.form.nominees.length;
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
    const financeFForm = this.formDataService.getFormFDetails();

    this.form.firstname = personalForm.firstname || basicForm.firstname;
    this.form.lastname = personalForm.lastname;
    this.form.gender = personalForm.gender;
    this.form.maritalStatus = personalForm.maritalStatus;
    this.form.religion = financeFForm.religion;
    this.form.ticketNumber = financeFForm.ticketNumber;
    this.form.dateOfAppointment = financeFForm.dateOfAppointment;

    this.form.presentAddress = !isEmpty(personalForm.presentAddress)
      ? new Address(personalForm.presentAddress)
      : new Address(basicForm.address);
    this.form.permanentAddress = !isEmpty(personalForm.permanentAddress)
      ? new Address(personalForm.permanentAddress)
      : new Address(basicForm.address);

    // Nominees
    for (let i = 0; i < 2; i++) {
      if (!this.form.nominees[i]) {
        this.form.nominees.push(new Nominee());
      }
    }
  }

  displayFullName(): string {
    return (this.form.firstname || '') + ' ' + (this.form.lastname || '').trim();
  }

  onPrevious(): void {
    this.save();
    this.router.navigateByUrl('/account/form/form-f');
  }

  onSubmit(): void {
    this.save();
    this.router.navigateByUrl('/account/form/form-q');
  }

  save(): boolean {
    if (this.formI.valid) {
      this.trimNominees();
      this.formDataService.setFormIDetails(this.form);
      return true;
    }
    return false;
  }

  trimNominees(): void {
    this.form.nominees = this.form.nominees.slice(0, this.noOfNominees || 0);
  }

  ngOnDestroy(): void {
    this.formISubscription.unsubscribe();
  }
}
