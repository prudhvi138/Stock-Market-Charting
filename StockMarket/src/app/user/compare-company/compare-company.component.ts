import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {
  compareCompany:FormGroup;
  constructor(private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.compareCompany=this.formBuilder.group({
      id:[],
      csselect: ['',Validators.required],
      seselect: ['',Validators.required],
      cnsn: ['',Validators.required],
      ctcnsn: ['',Validators.required],
      fperiod: ['',Validators.required],
      tperiod: ['',Validators.required],
     });
  }

  onSubmit() {

    this.router.navigate(["/chart"],{
      queryParams:{
        formData:JSON.stringify(this.compareCompany.value)
      }
    });

  }

}
