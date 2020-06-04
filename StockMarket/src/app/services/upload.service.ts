import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  httpUrl = environment.url +  "stock-price-service/stockprice/";
  constructor(private httpClient:HttpClient) { }
  uploadStocksSheet(formData:  FormData):Observable<void>{
    return this.httpClient.post<void>(this.httpUrl+"uploadStockSheet",formData);
  }
}
