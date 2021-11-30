import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { Orders } from './orders.component';

export type MetricsKey = 'jvm' | 'http.server.requests' | 'cache' | 'services' | 'databases' | 'garbageCollector' | 'processMetrics';
export type Metrics = { [key in MetricsKey]: any };
export type Thread = any;
export type ThreadDump = { threads: Thread[] };

@Injectable({ providedIn: 'root' })
export class OrdersService {
  public resourceUrl = SERVER_API_URL + 'api/orders';

  constructor(private http: HttpClient) {}

  create(order: Orders): Observable<Orders> {
    return this.http.post<Orders>(this.resourceUrl, order);
  }

  get(): Observable<Orders[]> {
    return this.http.get<Orders[]>(this.resourceUrl);
  } 

  update(user: Orders): Observable<Orders> {
    return this.http.put<Orders>(this.resourceUrl, user);
  }
}
