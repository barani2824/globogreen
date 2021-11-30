import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CompleteForm } from 'app/shared/models/forms.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private baseUrl = 'api/employee';

  constructor(private http: HttpClient) {}

  public post(form: CompleteForm): Observable<CompleteForm> {
    return this.http.post<CompleteForm>(`${this.baseUrl}/save`, form);
  }

  public get(email: string | undefined): Observable<CompleteForm> {
    return this.http.get<CompleteForm>(`${this.baseUrl}/get/${email}`);
  }

  public getDummy(): Observable<CompleteForm> {
    return this.http.get<CompleteForm>('assets/mock-up-data.json');
  }
}
