import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StockexchangeService } from 'src/app/services/stockexchange.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-stockexchange',
  templateUrl: './update-stockexchange.component.html',
  styleUrls: ['./update-stockexchange.component.css']
})
export class UpdateStockexchangeComponent implements OnInit {

  updateForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private stockexchangeService:StockexchangeService,private router:Router) { }
  
  ngOnInit() {
    this.updateForm=this.formBuilder.group({
      id:[],
      stock: ['',Validators.required],
      brief: ['',Validators.required],
      address: ['',Validators.required],
      remarks: ['',Validators.required],
     });
     const id = localStorage.getItem('exchangeId');
     if (+id > 0) {
       this. stockexchangeService.getStockExchangeById(+id).subscribe(StockExchange => {
         this.updateForm.patchValue(StockExchange);
       });
     }
   }
   UpdateStockExchange() {
     this.stockexchangeService.updateStockExchange(this.updateForm.value).subscribe(data => {
       this.router.navigate(['manage-exchange']);
     },
       error => {
         alert(error);
       });
     }

}
