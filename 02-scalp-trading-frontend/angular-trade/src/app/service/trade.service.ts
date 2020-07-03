import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Trade} from '../common/trade';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TradeService {

  private baseUrl = 'http://localhost:8080/api/trades';

  constructor(private httpClient: HttpClient) { }

  getTradeList(): Observable<Trade[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.trades)
    );
  }
}

interface GetResponse {
  _embedded: {
    trades: Trade[];
  };
}

