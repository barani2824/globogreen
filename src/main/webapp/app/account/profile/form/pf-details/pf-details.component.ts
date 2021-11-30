import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MaritialStatus } from 'app/shared/models/enums.models';
import { ProvidentFundForm } from 'app/shared/models/forms.model';
import { isEmpty } from 'app/shared/util/utilities';
import { Subscription } from 'rxjs';
import { FormDataService } from '../services/form-data.service';

@Component({
  selector: 'jhi-finance-details-form',
  templateUrl: './pf-details.component.html',
  styleUrls: ['./pf-details.component.scss'],
})
export class ProvidentFundDetailsFormComponent implements OnInit, OnDestroy {
  @ViewChild('pfForm', { static: false })
  public pfForm!: NgForm;
  public maritalStatuses = MaritialStatus;
  public form: ProvidentFundForm = new ProvidentFundForm();
  public providentFundFormSubscription!: Subscription;
  public fatherOrSpouse: 'Father' | 'Spouse' = 'Father';
  constructor(private router: Router, private formDataService: FormDataService) {}

  ngOnInit(): void {
    this.providentFundFormSubscription = this.formDataService.onDataLoaded().subscribe(
      res => {
        if (res) {
          this.form = new ProvidentFundForm(this.formDataService.getProvidentFundFormDetails());
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
    this.form.lastname = personalForm.lastname || basicForm.lastname;
    this.form.dateOfBirth = personalForm.dateOfBirth;
    this.form.gender = personalForm.gender;
    this.form.maritalStatus = personalForm.maritalStatus;
    this.form.email = this.form.email || personalForm.email;
    this.form.phone = this.form.phone ? this.form.phone : !isEmpty(personalForm.phones[0]) ? personalForm.phones[0].number : null;

    this.form.previousEmployment.passportNumber = personalForm.passportNumber;
    this.form.previousEmployment.dateOfIssue = personalForm.dateOfIssue;
    this.form.previousEmployment.dateOfExpiry = personalForm.dateOfExpiry;

    this.form.aadharNumber = personalForm.aadharNumber;
    this.form.panNumber = personalForm.panNumber;
  }

  displayFullName(): string {
    return (this.form.firstname || '') + ' ' + (this.form.lastname || '').trim();
  }

  onPrevious(): void {
    this.save();
    this.router.navigateByUrl('/account/form/personal-form');
  }

  onSubmit(): void {
    this.save();
    this.router.navigateByUrl('/account/form/form-f');
  }

  save(): boolean {
    if (this.pfForm.valid) {
      this.formDataService.setProvidentFundFormDetails(this.form);
      return true;
    }
    return false;
  }

  ngOnDestroy(): void {
    this.providentFundFormSubscription.unsubscribe();
  }
}
