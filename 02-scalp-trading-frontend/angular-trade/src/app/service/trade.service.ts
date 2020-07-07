import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Trade} from '../common/trade';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TradeService {

  private baseUrl = 'http://localhost:8080/api/trades';

  constructor(private httpClient: HttpClient) {
  }

  getTradeUsers(): Observable<Trade[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.trades)
    );
  }

  // getTradeList(theUserId: number): Observable<Trade[]> {
  //   const searchUrl = `${this.baseUrl}/search/findByUserId?id=${theUserId}`;
  //   return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
  //     map(response => response._embedded.trades)
  //   );
  // }

  searchTrades(theKeyword: string): Observable<Trade[]> {

    const searchUrl = `${this.baseUrl}/search/findByUnderlyingContaining?underlying=${theKeyword}`;

    return this.httpClient.get<GetResponse>(searchUrl).pipe(
      map(response => response._embedded.trades)
    );
  }
}

interface GetResponse {
  _embedded: {
    trades: Trade[];
  };
}
