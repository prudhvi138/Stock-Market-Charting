import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { CompanyService } from 'src/app/services/company.service';
@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companyForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private companyService: CompanyService) { }
  addCompany(){
    this.companyService.saveCompany(this.companyForm.value).subscribe(data => {
       alert('Company Inserted Successfully' +data);
       this.companyForm.reset()
     });
   }
   
   deleteCompany(){
     this.companyService.deleteCompany(this.companyForm.value).subscribe(data=>{
       alert('Company Deleted Successfully' +data);
     });
   }  
  ngOnInit() {
    this.companyForm=this.formBuilder.group({
      id:[],
      companyname: ['',Validators.required],
      turnover: ['',[Validators.required]],
      ceo: ['',Validators.required],
      bod: ['',Validators.required],
      lse: ['',Validators.required],
      sector: ['',Validators.required],
      boc: ['',Validators.required],
      stock: ['',Validators.required],
     });
  }

}
