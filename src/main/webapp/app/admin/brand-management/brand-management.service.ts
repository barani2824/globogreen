import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { SERVER_API_URL } from 'app/app.constants';



@Injectable({ providedIn: 'root' })
export class BrandManagementService {
  public resourceUrl = SERVER_API_URL + 'api/orders';

  constructor(private http: HttpClient) {}

  
}
