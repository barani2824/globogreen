import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ProfileCrudService } from './profile.service';
@Component({
  selector: 'jhi-profile',
  templateUrl: './profile.component.html',
})
export class ProfileComponent implements OnInit {
  profileForm: any;
  submitted = false;
  success = false;
  error = false;
  constructor(private fb: FormBuilder, private profileService: ProfileCrudService) {}

  ngOnInit(): void {
    this.profileForm = this.fb.group({
      firstName: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      passportNumber: ['', [Validators.required]],
      passportIssuedDate: ['', [Validators.required]],
      maritalStatus: ['', [Validators.required]],

      dob: ['', [Validators.required]],
      aadhar: ['', [Validators.required]],
      email: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      nationality: ['', [Validators.required]],
      placeOfIssue: ['', [Validators.required]],
      daeOfExpiry: ['', [Validators.required]],
      placeOfBirth: ['', [Validators.required]],
      pan: ['', [Validators.required]],
      presentAddress: ['', [Validators.required]],
      presentPin: ['', [Validators.required]],
      permenantAddress: ['', [Validators.required]],
      permenantPin: ['', [Validators.required]],
    });
  }
  public get f(): any {
    return this.profileForm.controls;
  }
  finishReset(): any {
    this.profileService.savePersonDetails(this.profileForm.value).subscribe(
      () => (this.success = true),
      () => (this.error = true)
    );
  }
  // changePassword(): void {
  //   this.error = false;
  //   this.success = false;
  //   this.doNotMatch = false;

  //   const newPassword = this.passwordForm.get(['newPassword'])!.value;
  //   if (newPassword !== this.passwordForm.get(['confirmPassword'])!.value) {
  //     this.doNotMatch = true;
  //   } else {
  //     this.passwordService.save(newPassword, this.passwordForm.get(['currentPassword'])!.value).subscribe(
  //       () => (this.success = true),
  //       () => (this.error = true)
  //     );
  //   }
  // }
}
