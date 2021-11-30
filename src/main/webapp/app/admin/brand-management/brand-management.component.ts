import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BrandManagementService } from './brand-management.service';
export type Brand = {
  id?: number,
  brandName: string,
  isSelected: boolean,
  modelCount: number


}
@Component({
  selector: 'jhi-brand-management',
  templateUrl: './brand-management.component.html',
  styleUrls: ['brand-management.component.scss'],
})
export class BrandManagementComponent implements OnInit {
  brandList: Brand[] = [];
  maxSize = 1000000;
  isMultipleUpload = false;
  brand: Brand = {
    brandName: '',
    modelCount: 0,
    isSelected: true
  };
  uploadedFiles: any[] = [];
  showBrand = false;
  isSaving = false;
  updatingMetrics = true;
  editForm = this.fb.group({
    customerName: ['', Validators.required],
    customerMobileNumber: [
      '',
      [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(50),
        Validators.pattern('^[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$|^[_.@A-Za-z0-9-]+$'),
      ],
    ],
    repairDetails: ['', [Validators.maxLength(50)]],
    orderStatus: ['', [Validators.maxLength(50)]],
    estimatedCost: [],
    customerEmail: [],
    mobileBrand: [],
    mobileModel: [],
    estimatedDeliveryTime: [],
    hasDisplayScratch: []
  });
  constructor(private brandService: BrandManagementService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    //  this.refresh();
  }
  save(): void {
    this.isSaving = true;

  }
  private onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }
  previousState(): void {
    window.history.back();
  }
  private onSaveError(): void {
    this.isSaving = false;
  }
  onUpload(event: any): void {
    alert('hi');
    for (const file of event.files) {
      this.uploadedFiles.push(file);
    }

  }
  addBrand(): void {
    this.brandList.push(this.brand);
    this.brand = {
      brandName: '',
      modelCount: 0,
      isSelected: true
    };
    this.showBrand = !this.showBrand;

  }
  showBrandTextBox(): void {

    this.showBrand = !this.showBrand;
  }
  addModel(): void {
    const brand: Brand = {
      brandName: 'Samsung',
      modelCount: 20,
      isSelected: true
    }
    this.brandList.push(brand);
  }
}
