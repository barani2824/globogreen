import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PdfService {
  private baseUrl = 'api/pdf';
  private headers = new HttpHeaders();
  constructor(private http: HttpClient) {
    this.headers.set('Accept', 'application/pdf');
  }

  public getAllForm(email: string | undefined): Observable<Blob> {
    return this.http.get(`${this.baseUrl}/allForms/${email}`, { headers: this.headers, responseType: 'blob' });
  }
}
