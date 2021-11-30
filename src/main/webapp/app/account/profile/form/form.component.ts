import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { debounceTime } from 'rxjs/operators';
import { FormDataService } from './services/form-data.service';

@Component({
  selector: 'jhi-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  @ViewChild('form', { static: false })
  public form!: ElementRef<any>;
  public currentTab: string | undefined;
  public currentForm: any;
  constructor(private router: Router, private activatedRoute: ActivatedRoute, public formDataService: FormDataService) {}

  ngOnInit(): void {
    this.currentTab = this.activatedRoute?.snapshot?.firstChild?.routeConfig?.path;
    this.router.events.pipe(debounceTime(100)).subscribe(() => {
      this.currentTab = this.activatedRoute?.snapshot?.firstChild?.routeConfig?.path;
    });
  }

  componentAdded($event: any): void {
    if (this.form) {
      this.form.nativeElement.scrollTop = 0;
    }
    this.currentForm = $event;
  }

  onTabClick(url: string): void {
    if (this.currentForm && this.currentForm.save()) {
      this.router.navigateByUrl('/account/form/' + url);
    } else {
      alert('Please fill the missing fields before navigation to other form!!.');
    }
  }
}
