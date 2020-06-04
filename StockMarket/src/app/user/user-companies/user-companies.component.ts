import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Router } from '@angular/router';
import { Company } from 'src/models/company';

@Component({
  selector: 'app-user-companies',
  templateUrl: './user-companies.component.html',
  styleUrls: ['./user-companies.component.css']
})
export class UserCompaniesComponent implements OnInit {

  constructor(private companyService :CompanyService, private router : Router) { }
  companies:Company[];
  ngOnInit() {

    this.companyService.getAllCompanies().subscribe(data=>{
      this.companies=data;
    });
}
}