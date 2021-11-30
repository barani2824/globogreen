import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { OrdersService, Metrics, Thread } from './orders.service';
export type Orders = {
  id: number,
  customerName: string,
  customerMobileNumber: string,
  repairDetails: string,
  orderStatus: string,
  estimatedCost: string,
  customerEmail: string,
  mobileBrand: string,
  mobileModel: string,
  estimatedDeliveryTime: string,
  hasDisplayScratch: boolean


}
@Component({
  selector: 'jhi-orders',
  templateUrl: './orders.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OrdersComponent implements OnInit {
  metrics?: Metrics;
  threads?: Thread[];
  order!: Orders;
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
  constructor(private orderService: OrdersService, private changeDetector: ChangeDetectorRef,
    private fb: FormBuilder) { }

  ngOnInit(): void {
  //  this.refresh();
  }
  save(): void {
    this.isSaving = true;
    this.updateOrder(this.order);
    if (this.order.id !== undefined) {
      this.orderService.update(this.order).subscribe(
        () => this.onSaveSuccess(),
        () => this.onSaveError()
      );
    } else {
      this.orderService.create(this.order).subscribe(
        () => this.onSaveSuccess(),
        () => this.onSaveError()
      );
    }
  }
  private updateForm(order: Orders): void {
    this.editForm.patchValue({
      id: order.id,
      customerName: order.customerName,
      customerMobileNumber: order.customerMobileNumber,
      repairDetails: order.repairDetails,
      orderStatus: order.orderStatus,
      estimatedCost: order.estimatedCost,
      customerEmail: order.customerEmail,
      mobileBrand: order.mobileBrand,
      mobileModel: order.mobileModel,
      estimatedDeliveryTime: order.estimatedDeliveryTime,
      hasDisplayScratch: order.hasDisplayScratch
    });
  }

  private updateOrder(order: any ): void {
    this.order=!order?{}:order;
    this.order.customerName = this.editForm.get(['customerName'])!.value;
    this.order.customerMobileNumber = this.editForm.get(['customerMobileNumber'])!.value;
    this.order.repairDetails = this.editForm.get(['repairDetails'])!.value;
    this.order.orderStatus = this.editForm.get(['orderStatus'])!.value;
    this.order.estimatedCost = this.editForm.get(['estimatedCost'])!.value;
    this.order.customerEmail = this.editForm.get(['customerEmail'])!.value;
    this.order.mobileBrand = this.editForm.get(['mobileBrand'])!.value;
    this.order.mobileModel = this.editForm.get(['mobileModel'])!.value;
    this.order.estimatedDeliveryTime = this.editForm.get(['estimatedDeliveryTime'])!.value;
    this.order.hasDisplayScratch = this.editForm.get(['hasDisplayScratch'])!.value;
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

}
