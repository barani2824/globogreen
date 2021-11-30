import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MaritialStatus } from 'app/shared/models/enums.models';
import { Address, FormF, Nominee } from 'app/shared/models/forms.model';
import { isEmpty } from 'app/shared/util/utilities';
import { Subscription } from 'rxjs';
import { FormDataService } from '../services/form-data.service';

@Component({
  selector: 'jhi-finance-form-f-details',
  templateUrl: './finance-form-f-details.component.html',
  styleUrls: ['./finance-form-f-details.component.scss'],
})
export class FinanceFormFDetailsComponent implements OnInit, OnDestroy {
  @ViewChild('formF', { static: false })
  public formF!: NgForm;
  public maritalStatuses = MaritialStatus;
  public form: FormF = new FormF();
  public formFSubscription!: Subscription;
  public noOfNominees = 0;
  public isProperProportion = false;
  constructor(private router: Router, private formDataService: FormDataService) {}

  ngOnInit(): void {
    this.formFSubscription = this.formDataService.onDataLoaded().subscribe(
      res => {
        if (res) {
          this.form = new FormF(this.formDataService.getFormFDetails());
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
    this.form.firstname = personalForm.firstname || basicForm.firstname;
    this.form.lastname = personalForm.lastname;
    this.form.gender = personalForm.gender;
    this.form.maritalStatus = personalForm.maritalStatus;

    this.form.permanentAddress = !isEmpty(personalForm.permanentAddress)
      ? new Address(personalForm.permanentAddress)
      : new Address(basicForm.address);

    // Nominees
    for (let i = 0; i < 4; i++) {
      if (!this.form.nominees[i]) {
        this.form.nominees.push(new Nominee());
      }
    }
    this.evaluateProportion();
  }

  displayFullName(): string {
    return (this.form.firstname || '') + ' ' + (this.form.lastname || '').trim();
  }

  onNoOfNomineesChange(): void {
    this.evaluateProportion();
  }

  onProportionChange(): void {
    this.evaluateProportion();
  }

  private evaluateProportion(): void {
    let sum = 0;
    for (let i = 0; i < this.noOfNominees; i++) {
      sum += this.form.nominees[i].proportion || 0;
    }
    this.isProperProportion = sum === 100;
  }

  onPrevious(): void {
    this.save();
    this.router.navigateByUrl('/account/form/pf-form');
  }

  onSubmit(): void {
    this.save();
    this.router.navigateByUrl('/account/form/form-i');
  }

  save(): boolean {
    if (this.formF.valid || !this.isProperProportion) {
      this.trimNominees();
      this.formDataService.setFormFDetails(this.form);
      return true;
    }
    return false;
  }

  trimNominees(): void {
    this.form.nominees = this.form.nominees.slice(0, this.noOfNominees || 0);
  }

  ngOnDestroy(): void {
    this.formFSubscription.unsubscribe();
  }
}
