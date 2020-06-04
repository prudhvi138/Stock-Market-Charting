import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockExchange } from 'src/models/stockexchange';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class StockexchangeService {
  httpUrl= environment.url + "stock-exchange-service/stockexchangeall/";
  exchange:StockExchange;
  constructor(private httpClient:HttpClient ,@Inject(HttpClient) private ht) { }
  saveStockExchange(exchange:StockExchange):Observable<StockExchange>{
    return this.httpClient.post<StockExchange>(this.httpUrl,exchange);
  }
  deleteStockExchange(id:number):Observable<StockExchange>{
    return this.ht.delete(this.httpUrl+id);
  }
  getAllStockExchanges():Observable<StockExchange[]>{
    return this.httpClient.get<StockExchange[]>(this.httpUrl);
  }
  updateStockExchange(exchange:StockExchange): Observable<StockExchange>{
    return this.ht.put(this.httpUrl,exchange);
  }
  getStockExchangeById(id: number): Observable<StockExchange> {
return this.ht.get(this.httpUrl+id);
  }
}