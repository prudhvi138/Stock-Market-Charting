import { Injectable, Inject } from '@angular/core';
import { Ipo } from 'src/models/ipo';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class IPOService {

  
  httpUrl= environment.url + "initial-public-offering-service/ipoall/";
  ipo:Ipo;
  constructor(private httpClient:HttpClient ,@Inject(HttpClient) private ht) { }
  saveIpo(ipo:Ipo):Observable<Ipo>{
    return this.httpClient.post<Ipo>(this.httpUrl, ipo);
  }
  deleteIpo(id:number):Observable<Ipo>{
    return this.ht.delete(this.httpUrl+id);
  }
  getAllIpos():Observable<Ipo[]>{
    return this.httpClient.get<Ipo[]>(this.httpUrl);
  }
  updateIpo(ipo :Ipo): Observable<Ipo>{
    return this.ht.put(this.httpUrl,ipo);
  }
  getIpoById(id: number): Observable<Ipo> {
return this.ht.get(this.httpUrl+id);
  }
}
