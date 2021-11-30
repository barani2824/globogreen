import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BloogGroup } from 'app/shared/models/enums.models';
import { BasicForm } from 'app/shared/models/forms.model';
import { Subscription } from 'rxjs';
import { FormDataService } from '../services/form-data.service';

@Component({
  selector: 'jhi-basic-details-form',
  templateUrl: './basic-details.component.html',
  styleUrls: ['./basic-details.component.scss'],
})
export class BasicDetailsFormComponent implements OnInit, OnDestroy {
  @ViewChild('basicForm', { static: false })
  public basicForm!: NgForm;
  public bloodGroups = BloogGroup;
  public form: BasicForm = new BasicForm();
  public basicFormSubscription!: Subscription;
  public photoUrl = '';
  public filename = '';
  public defaultUrl = '../../../../../content/images/dummyBackground.jpg';

  constructor(private router: Router, private formDataService: FormDataService) {}

  ngOnInit(): void {
    this.basicFormSubscription = this.formDataService.onDataLoaded().subscribe(
      res => {
        if (res) {
          this.form = new BasicForm(this.formDataService.getBasicFormDetails());
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
    if (this.form.photo) {
      this.photoUrl = this.form.photo;
    }

    this.form.firstname = this.form.firstname ? this.form.firstname : this.formDataService.getFirstname();
    this.form.lastname = this.form.lastname ? this.form.lastname : this.formDataService.getLastName();
  }

  onSubmit(): void {
    this.save();
    this.router.navigateByUrl('/account/form/personal-form');
  }

  save(): boolean {
    if (this.basicForm.valid && this.form.photo) {
      this.formDataService.setBasicFormDetails(this.form);
      return true;
    }
    return false;
  }

  onPhotoSelect(event: any): void {
    if (event.target.files && event.target.files[0]) {
      this.handlePhoto(event.target.files[0]);
    } else {
      this.form.photo = this.form.photo || null;
    }
  }

  onPhotoDropped(file: any): void {
    this.handlePhoto(file);
  }

  private handlePhoto(file: any): void {
    this.filename = file.name;
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = (e: any) => {
      this.photoUrl = e.target.result;
      this.form.photo = this.photoUrl;
    };
  }

  ngOnDestroy(): void {
    this.basicFormSubscription.unsubscribe();
  }
}
