import { Component, OnInit } from '@angular/core';
import { StockExchange } from 'src/models/stockexchange';
import { Router } from '@angular/router';
import { StockexchangeService } from 'src/app/services/stockexchange.service';

@Component({
  selector: 'app-manage-exchange',
  templateUrl: './manage-exchange.component.html',
  styleUrls: ['./manage-exchange.component.css']
})
export class ManageExchangeComponent implements OnInit {
  constructor(private stockExchangeService:StockexchangeService,private router:Router) { }
  exchanges:StockExchange[];
  ngOnInit() {
    this.stockExchangeService.getAllStockExchanges().subscribe(data => {
      this.exchanges=data;
    });
  }
  deleteStockExchange(id:number){
    this.stockExchangeService.deleteStockExchange(id).subscribe(data=>{
    this.exchanges=this.exchanges.filter(exchange => exchange.id!== id);
  });
  }
  updateStockExchange(exchanges:StockExchange)
  {
    localStorage.removeItem('exchangeId');
    localStorage.setItem('exchangeId',exchanges.id.toString());
    this.router.navigate(['update-stockexchange']);
  }

}
