import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MaritialStatus, Title } from 'app/shared/models/enums.models';
import { Address, Dependent, EmergencyContact, PersonalForm } from 'app/shared/models/forms.model';
import { getMobilePhone, isEmpty } from 'app/shared/util/utilities';
import { Subscription } from 'rxjs';
import { FormDataService } from '../services/form-data.service';

@Component({
  selector: 'jhi-personal-details-form',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.scss'],
})
export class PersonalDetailsFormComponent implements OnInit, OnDestroy {
  @ViewChild('personalForm', { static: false })
  public personalForm!: NgForm;
  public titles = Title;
  public maritalStatuses = MaritialStatus;
  public noOfDependents = 0;
  public form: PersonalForm = new PersonalForm();
  public personalFormSubscription!: Subscription;
  constructor(private router: Router, private formDataService: FormDataService) {}

  ngOnInit(): void {
    this.personalFormSubscription = this.formDataService.onDataLoaded().subscribe(
      res => {
        if (res) {
          this.form = new PersonalForm(this.formDataService.getPesonalFormDetails());
          this.noOfDependents = this.form.dependents.length;
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
    this.form.firstname = basicForm.firstname;
    this.form.lastname = basicForm.lastname;

    this.form.presentAddress = !isEmpty(this.form.presentAddress) ? new Address(this.form.presentAddress) : new Address(basicForm.address);
    this.form.permanentAddress = new Address(basicForm.address);

    this.form.dateOfBirth = basicForm.dateOfBirth;
    this.form.gender = this.form.gender || 'Female';

    this.form.email = this.formDataService.getEmail();

    // Phones
    if (!this.form.phones[0]) {
      this.form.phones.push(getMobilePhone());
    }

    // Emergency Contacts
    for (let i = 0; i < 2; i++) {
      if (!this.form.emergencyContacts[i]) {
        this.form.emergencyContacts.push(new EmergencyContact());
      }
    }

    // Dependents
    for (let i = 0; i < 2; i++) {
      if (!this.form.dependents[i]) {
        this.form.dependents.push(new Dependent());
      }
    }
  }

  onPrevious(): void {
    this.save();
    this.router.navigateByUrl('/account/form/basic-form');
  }

  onSubmit(): void {
    this.save();
    this.router.navigateByUrl('/account/form/pf-form');
  }

  save(): boolean {
    if (this.personalForm.valid) {
      this.trimDependents();
      this.formDataService.setPesonalFormDetails(this.form);
      return true;
    }
    return false;
  }

  trimDependents(): void {
    this.form.dependents = this.form.dependents.slice(0, this.noOfDependents || 0);
  }

  ngOnDestroy(): void {
    this.personalFormSubscription.unsubscribe();
  }
}
