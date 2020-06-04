import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StockexchangeService } from 'src/app/services/stockexchange.service';

@Component({
  selector: 'app-stock-exchange',
  templateUrl: './stock-exchange.component.html',
  styleUrls: ['./stock-exchange.component.css']
})
export class StockExchangeComponent implements OnInit {

  StockForm:FormGroup;
  constructor(private formBuilder:FormBuilder,private stockexchangeService:StockexchangeService) 
  { }
  ngOnInit() 
  {
    this.StockForm=this.formBuilder.group({
      id:['',[Validators.required]],
     stock:['',[Validators.required]],
    brief:['',[Validators.required]],
    address:['',[Validators.required]],
    remarks:['',[Validators.required]]
    });
  }
  addStock()
  {
    this.stockexchangeService.saveStockExchange(this.StockForm.value).subscribe
    (data => {
      alert('StockExchange Inserted Successfully' +data);
      this.StockForm.reset();
    });
  }
  deleteStockExchange()
  {
    this.stockexchangeService.deleteStockExchange(this.StockForm.value).subscribe
    (data => {
      alert('StockExchange Deleted Successfully' +data);
    });
  }
  onSubmit()
  {
    console.log(this.StockForm.value);
  }
}
